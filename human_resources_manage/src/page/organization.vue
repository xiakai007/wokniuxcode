<template lang="html">
    <div>
        <head-top></head-top>
        <div class="main" style="padding: 10px;">
         <span class="dian"></span>
            <div class="btn_div">
                <el-button type="info" @click="loadExcl">模板下载</el-button>
                <!--<el-button type="info" @click="modelIn">信息导入</el-button>-->
                <div class="a">
                <form>
                    <input type="file" @change="getFile($event)">
                    <el-button class="button button-primary button-pill button-small" @click="submit($event)">批量导入</el-button>
                </form>
                </div>
            </div>
        </div>
            <tree-chart></tree-chart>
    </div>

</template>

<script>
    import axios from 'axios'
    import headTop from '../components/headTop'
    import header from "../components/header"
    import filter from "../components/filter"
    import treeChart from "./treeChart";
    export default {
        name: 'Organization',
        components: {
            "v-header": header,
            "v-filter": filter,
            headTop,
            treeChart
        },
        methods :{
            clickNode: function(node){
                // eslint-disable-next-line
                console.log(node)
            },
            loadExcl()
            {
                // 基于准备好的dom，初始化echarts实例
                // this.loadExcl = echarts.init(document.querySelector(".line .main"));

                axios.get("http://localhost:8080/hr_manager/organization/loadExclOrganization",{responseType:'blob'}).then(res => {
                    console.log(res)
                    var filename = 'Excel_Organization';
                    let url = window.URL.createObjectURL(new Blob([res.data]))
                    let link = document.createElement('a')
                    link.style.display = 'none'
                    link.href = url
                    link.setAttribute('download', filename + '.xlsx')
                    document.body.appendChild(link)
                    link.click()
                }
            );

            },
            getFile: function (event) {
                this.file = event.target.files[0];
                console.log(this.file);
            },
            submit: function (event) {
                //阻止元素发生默认的行为
                event.preventDefault();
                let formData = new FormData();
                formData.append("file", this.file);
                axios.post('http://127.0.0.1:8080/hr_manager/organization/importExclOrganization', formData)
                    .then(function (response) {
                        alert(response.data);
                        console.log(response);
                    })
                    .catch(function (error) {
                        alert("上传失败");
                        console.log(error);
                    });
            }
        }
    };
</script>

<style lang="less">
    @import '../style/mixin';
    .table_container{
        padding: 20px;
    }
    .a{
        position: relative;
        left: 500px;
        top: -30px
    }
</style>
