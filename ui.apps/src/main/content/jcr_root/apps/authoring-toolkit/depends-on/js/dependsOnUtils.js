/**
 * @author Alexey Stsefanovich (ala'n), Yana Bernatskaya (YanaBr)
 * @version 2.5.0
 *
 * DependsOn plugin utils
 * */
(function ($, ns) {
    'use strict';

    /**
     * Create sequence generator
     * */
    ns.createSequence = function () {
        let index = 1;
        return { next: () => index++ };
    };

    /**
     * Split string
     * @param {string} value
     * @returns {string[]}
     * */
    ns.splitAndTrim = function splitAndTrim(value) {
        const parts = value.replace(/\\;/g, '#~#').split(';');
        return parts.map((term) => term.replace(/#~#/g, ';').trim());
    };

    /**
     * Extended comparison that supports NaN, Arrays and Objects
     * @returns {boolean}
     * */
    ns.isEqual = function isEqual(a, b) {
        if (a === b) return true;
        if (typeof a !== typeof b) return false;
        // eslint-disable-next-line no-self-compare -- check that both are NaNs
        if (a !== a && b !== b) return true;
        if (Array.isArray(a) && Array.isArray(b)) {
            return a.length === b.length && a.every((val, i) => isEqual(val, b[i]));
        }
        if (ns.isObject(a) && ns.isObject(b)) {
            const keysA = Object.keys(a);
            const keysB = Object.keys(b);
            if (keysA.length !== keysB.length) return false;
            return keysA.every((key) => isEqual(a[key], b[key]));
        }
        return false;
    };

    /**
     * Cast field value to passed type
     * @param value
     * @param {'boolean'|'boolstring'|'number'|'string'|'json'|'any'} type
     * */
    ns.castToType = function (value, type) {
        switch (type.toLowerCase()) {
            case 'boolean':
                return Boolean(value);
            case 'boolstring':
                return String(value) === 'true';
            case 'number':
                return Number(value);
            case 'string':
                return String(value);
            case 'json':
                return ns.parseSafe(value);
            default:
                return value;
        }
    };

    /**
     * Find 'scope' element by provided selector. Use back-forward search:
     * First part of the selector will be used to find the closest element (base)
     * If the second part after '|>' is provided,
     * function will search element by the second part of the selector inside the base element.
     * If 'this' is passed as the first part of the selector, $root will be returned.
     * If the selector is not provided then the result will be $(document).
     *
     * @param {JQuery} $root
     * @param {string} selector
     * */
    ns.findScope = function ($root, selector) {
        if (!(selector || '').trim()) return $(document.body);
        const [parent, child] = selector.split('|>').map((term) => term.trim());
        const $base = (parent === 'this') ? $root : $root.parent().closest(parent);
        return child ? $base.find(child) : $base;
    };

    /**
     * Parse action data params into object
     * @param {HTMLElement} el - target element
     * @param {string} actionName
     * @param {number} [index] - action order if multiple actions of the same type attached
     * @returns {object}
     * */
    ns.parseActionData = function (el, actionName = '', index = 0) {
        const prefix = `data-dependson-${actionName}-`;
        const suffix = index ? `-${index}` : '';

        let attrs = [].slice.call(el.attributes);
        attrs = attrs.filter((attr) => attr.name.slice(0, prefix.length) === prefix);
        attrs = index ?
            attrs.filter((attr) => attr.name.slice(-suffix.length) === suffix) :
            attrs.filter((attr) => !/-(\d+)$/.test(attr.name));

        // Build object
        return attrs.reduce((data, attr) => {
            const name = attr.name.slice(prefix.length, attr.name.length - suffix.length);
            if (name) data[name] = attr.value;
            return data;
        }, {});
    };

    /**
     * @param $el {JQuery}
     * @param state {boolean}
     */
    ns.toggleAsterisk = function ($el, state) {
        $el.text($el.text().replace(/\s?\*?$/, state ? ' *' : ''));
    };

    /**
     * Get current component path
     * @param {JQuery} item - dialog form element, could be just "this" in dependsOn (query)
     * @returns string
     * */
    ns.getDialogPath = function (item) {
        return item.closest('form.cq-dialog').attr('action');
    };

    /**
     * Check if the passed value is an object
     * @param value - value to check
     * @returns {boolean} true if the value is an object, false otherwise
     * */
    ns.isObject = function (value) {
        return value !== null && typeof value === 'object';
    };

    /**
     * Attempts to parse a string value into JSON object
     * @param {string} value to parse
     * @return {Object} parsed value or an empty object in case of any exceptions
     */
    ns.parseSafe = function (value) {
        try {
            return JSON.parse(value);
        } catch (e) {
            return {};
        }
    };

    /**
     * Parse function string to a real function.
     * @param {string|function} exp
     * @param {function} defaultFn
     */
    ns.evalFn = function evalFunction(exp, defaultFn) {
        if (!exp) return defaultFn;
        if (typeof exp === 'function') return exp;
        let fn = defaultFn;
        try {
            fn = (new Function(`return ${exp}`))(); // NOSONAR: not a javascript:S3523 case, real evaluation should be done
        } catch (e) {
            console.error(`[DependsOn]: can not process function '${exp}': `, e);
        }
        if (typeof fn !== 'function') {
            console.error(`[DependsOn]: evaluation '${exp}' result is not a function`);
            return defaultFn;
        }
        return fn;
    };
})(Granite.$, Granite.DependsOnPlugin = (Granite.DependsOnPlugin || {}));
