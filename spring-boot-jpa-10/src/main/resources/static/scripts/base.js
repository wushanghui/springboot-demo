inputMaxLenValidation = function (elements) {
    //元素选择器
    var eleSelector = elements || '.txt-valid-len';
    function strRealLength(str) {
        var realLength = 0, len = str.length, charCode = -1;
        for (var i = 0; i < len; i++) {
            charCode = str.charCodeAt(i);
            //UTF-8 字符长度计算
            if (charCode <= parseInt("0x7F")) {
                realLength += 1;
            } else if (charCode <= parseInt("0x7FF")) {
                realLength += 2;
            } else {
                realLength += 3;
            }
        }
        return realLength;
    }
    function strCutToLimet(str, maxLen) {
        if (maxLen <=0 || str == null || str == "") {
            return "";
        }
        var len = str.length;
        var result;
        if (len >= maxLen) {
            result = str.substr(0, maxLen);
        } else {
            result = str;
        }
        while (strRealLength(result) > maxLen) {
            result = result.substr(0,result.length-1);
        }
        return result;
    }
    $(eleSelector).on("keypress", function (e) {
        if (e.keyCode == 8) {
            return true;
        } else {
            var maxLen = $(this).attr("maxCodeLength") || 0;
            if (maxLen > 0) {
                return (strRealLength(this.value) <= maxLen);
            }
        }
    });
    $(eleSelector).on("paste", function (e) {
        var maxLen = $(this).attr("maxCodeLength") || 0;
        var currRealLen = strRealLength(this.value);
        if (maxLen > 0 && currRealLen < maxLen) {
            if (e.clipboardData) {
                //
            }
            return true;
        }
        return false;
    });
    $(eleSelector).on("keyup input", function (e) {
        var keyCode = e.keyCode || e.which || e.charCode;
        if (makeyCode == 46 || makeyCode == 8) {
            //
        } else {
            var maxLen = $(this).attr("maxCodeLength") || 0;
            if (maxLen > 0) {
                var currRealLen = strRealLength(this.value);
                if (currRealLen > maxLen) {
                    this.value = strCutToLimet(this.value, maxLen);
                }
            }
        }
        return false;
    });
    $(eleSelector).on("change", function () {
        var maxLen = $(this).attr("maxCodeLength") || 0;
        if (maxLen > 0) {
            var currRealLen = strRealLength(this.value);
            if (currRealLen > maxLen) {
                this.value = strCutToLimet(this.value, maxLen);
            }
        }
    });
}