<template>
        <el-tree
            :data="tree.data3"
            :expand-on-click-node=false
            :props="defaultProps"
            node-key="number"
            :default-expanded-keys="['1']"
            :default-expand-all="false"
            :render-content="tree.renderContent"
            @current-change="changeSelect">
        </el-tree>
</template>

<script>
    import axios from 'axios'
    export default {
        props: {
            treeParams: { type: Object, default() { return {} } }
        },
        data() {
            return {
                tree: {
                    data3: [],
                    renderContent: (h, {node, data, store}) => {
                        let iconClass = data.type === '1' ? 'security icon-controlCenter' : 'security icon-region';
                        let options = {};
                        options = {
                            attrs: {draggable: true},
                            on: {
                                click: function (e) {
                                    console.log(e)
                                }
                            }
                        };
                        return h('span', options, [h('i', {attrs: {class: iconClass}}), h('span', {style: {marginLeft: '10px'}}, node.label)]);
                    }
                },
                defaultProps: {
                    children: 'children',
                    label: 'organizationName'
                }
            }
        },
        watch: {
            treeParams: {
                deep: true,
                handler( ) {
                        this.getData()
                }
            }
        },
        created() {
            this.getData();
        },
        methods: {
            // 切换树
            changeSelect(data, nodeInfo) {
                this.$emit('changeSelect', data, nodeInfo);
            },
            // 获取树形结构数据
            getData() {
                let self = this;
                axios.get("http://localhost:8080/hr_manager/organization/getTreeOrganization?employeeID=82886").then(res => {
                        self.tree.data3 = res.data
                        console.log(res.data)
                        this.$emit('setData', self.tree.data3[0]);
                    console.log(res.data)

                })
            }
        }
    }
</script>

<style scoped>

</style>
