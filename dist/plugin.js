var capacitorShare = (function (exports, core) {
    'use strict';

    const Share = core.registerPlugin('Share', {
        web: () => Promise.resolve().then(function () { return web; }).then(m => new m.ShareWeb()),
    });

    class ShareWeb extends core.WebPlugin {
        async share(_options) {
            return { value: "success" };
        }
    }

    var web = /*#__PURE__*/Object.freeze({
        __proto__: null,
        ShareWeb: ShareWeb
    });

    exports.Share = Share;

    Object.defineProperty(exports, '__esModule', { value: true });

    return exports;

})({}, capacitorExports);
//# sourceMappingURL=plugin.js.map
