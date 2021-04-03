// 定义常用的校验，常用的正则 https://www.open-open.com/code/view/1430625516632
layui.define(['jquery'], function (exports) {
    var $ = layui.jquery;
    exports('validate', {
        username: function (value, item) {
            if (!isEmpty(value)) {
                var result = '';
                $.ajax({
                    url: ctx + 'user/check/' + value,
                    data: {
                        "userId": item.getAttribute('id')
                    },
                    async: false,
                    type: 'get',
                    success: function (d) {
                        (!d) && (result = '该用户名已存在')
                    }
                });
                if (!isEmpty(result)) {
                    return result;
                }
            }
        },
        cron: function (value, item) {
            if (!isEmpty(value)) {
                var result = '';
                $.ajax({
                    url: ctx + 'job/cron/check',
                    data: {
                        "cron": value
                    },
                    async: false,
                    type: 'get',
                    success: function (d) {
                        (!d) && (result = 'cron表达式不合法')
                    }
                });
                if (!isEmpty(result)) {
                    return result;
                }
            }
        },
        email: function (value) {
            if (!isEmpty(value)) {
                if (!new RegExp("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$").test(value)) {
                    return '请填写正确的邮箱';
                }
            }
        },
        phone: function (value) {
            if (!isEmpty(value)) {
                if (!new RegExp("^1\\d{10}$").test(value)) {
                    return '请填写正确的手机号码';
                }
            }
        },
        number: function (value) {
            if (!isEmpty(value)) {
                if (!new RegExp("^[0-9]*$").test(value)) {
                    return '只能填写数字';
                }
            }
        },
        chinese:function (value, item) {
            if(!new RegExp("^[\u4e00-\u9fa5]{0,}$").test(value)){
                return "只能填中文";
            }
        },
        dimIdentity: function (value, item) {
                if(!new RegExp("^[0-9xX]*$").test(value)){
                    return "只能填数字和xX";
                }
        },
        txt: function (value, item) {
            if(new RegExp(".*?script[^>]*?.*?(<\/.*?script.*?>)*", "ig").test(value)){
                return "内容包含脚本内容，请重新输入！";
            }
        },
        excludeSql: function (value, item) {
            if(filterSqlStr(value)){
                return "所填内容中包含了敏感字符"+sql_str()+",请重新输入！";
            }
        },
        range: function (value, item) {
            var minlength = item.getAttribute('minlength') ? item.getAttribute('minlength') : -1;
            var maxlength = item.getAttribute('maxlength') ? item.getAttribute('maxlength') : -1;
            var length = value.length;
            if (minlength === -1) {
                if (length > maxlength) {
                    return '长度不能超过 ' + maxlength + ' 个字符';
                }
            } else if (maxlength === -1) {
                if (length < minlength) {
                    return '长度不能少于 ' + minlength + ' 个字符';
                }
            } else {
                if (length > maxlength || length < minlength) {
                    return '长度范围 ' + minlength + ' ~ ' + maxlength + ' 个字符';
                }
            }
        },

        /**
         * @author zhaojw
         * @data 2021/02/01
         * @param value
         * @returns {string}
         * 文本框验证固话功能
         */
        fixedLine:function (value) {
            if (!isEmpty(value)) {
                if (!new RegExp("^\\d{3,4}-\\d{7,8}$").test(value)) {
                    return '请填写正确的座机号码，如029-85135982';
                }
            }
        },


        /**
         * @author zhaojw
         * @data 2021/02/01
         * @param value
         * @returns {string}
         * 文本框验证特殊字符功能
         */
        char:function (value) {
            if (!isEmpty(value)) {
                if (!new RegExp("^[\u4E00-\u9FA5A-Za-z0-9-（）()]+$").test(value)) {
                    return '不能输入特殊符号，请检查';
                }
            }
        }
    });

    function filterSqlStr(value){

        var sqlStr=sql_str().split(',');
        var flag=false;

        for(var i=0;i<sqlStr.length;i++){

            if(value.toLowerCase().indexOf(sqlStr[i])!=-1){
                flag=true;
                break;

            }
        }
        return flag;
    }
    function sql_str() {
        var str = "and,delete,or,exec,insert,select,union,update,count,*,',join,>,<";
        return str;
    }
    function isEmpty(obj) {
        return typeof obj == 'undefined' || obj == null || obj === '';
    }
});