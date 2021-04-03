<template lang="html">
    <div class="fillcontain">
        <head-top></head-top>
        <div class="table_container">
            <el-table
		      :data="tableData"
		      style="width: 100%">
		      <el-table-column
                type="index"
                label="序号"
                width="100">
                </el-table-column>
              <el-table-column
		        prop="user_name"
		        label="用户名">
		      </el-table-column>
              <el-table-column
		        prop="real_name"
		        label="真实姓名">
		      </el-table-column>
		      <el-table-column
		        prop="business_line"
		        label="所属业务线"
		        width="260">
		      </el-table-column>
              <el-table-column
                prop="email"
                label="邮箱地址"
                width="260">
              </el-table-column>
		      <el-table-column
		        prop="create_time"
		        label="创建时间">
		      </el-table-column>
              <el-table-column
		        prop="status"
		        label="状态">
		      </el-table-column>
            <el-table-column
		        prop="status"
		        label="操作">
                <template slot-scope="scope">
                        <el-button type="text" icon="el-icon-edit" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                        <el-button type="text" icon="el-icon-delete" class="red" @click="handleDelete(scope.$index, scope.row)">激活</el-button>
                        <el-button type="text" icon="el-icon-delete" class="red" @click="handleDelete(scope.$index, scope.row)">停用</el-button>
                </template>
		      </el-table-column>
		    </el-table>
		    <div class="Pagination" style="text-align: left;margin-top: 10px;">
                <el-pagination
                  @size-change="handleSizeChange"
                  @current-change="handleCurrentChange"
                  :current-page="currentPage"
                  :page-size="20"
                  layout="total, prev, pager, next"
                  :total="count">
                </el-pagination>
            </div>
        </div>
    </div>
</template>

<script>
    import axios from "axios";
    import headTop from '../components/headTop'
    export default {
        data(){
            return {
                tableData: [],
                currentRow: null,
                offset: 0,
                limit: 15,
                count: 0,
                currentPage: 1,
                id:1,
                total:null
            }
        },
    	components: {
    		headTop,
    	},
        created(){
            this.initData();
        },
        methods: {
            initData(){
                var self = this
                let params = {
                    "page" : self.currentPage,
                    "pageSize" :self.limit
                }
                axios.post("getway/hr_manager/user/query_user",params) 
                .then(function (res) {
                    console.log(res);
                    if (res.status == 200) {
                    	self.tableData = [];
                    	res.data.list.forEach(item => {
                    		const tableItem = {
                    			create_time: item.registerTime,
						        user_name: item.username,
						        real_name: item.realName,
                                business_line: item.inBusinessLine,
                                status:item.status,
                                email:item.email,
                                order_number:item.index
                    		}
                    		self.tableData.push(tableItem)
                        })
                        console.log(self.tableData);
                    }else{
                    	throw new Error(res.statusText)
                    }
                })
                .catch(function (error) {
                    console.log(error);
                })
            },
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
            },
            handleCurrentChange(val) {
                this.currentPage = val;
                this.offset = (val - 1)*this.limit;
                this.initData()
            },
            // async getAdmin(){
            //     try{
            //         const res = await adminList({offset: this.offset, limit: this.limit});
            //         if (res.status == 1) {
            //         	this.tableData = [];
            //         	res.data.forEach(item => {
            //         		const tableItem = {
            //         			create_time: item.create_time,
			// 			        user_name: item.user_name,
			// 			        admin: item.admin,
            //                     city: item.city,
            //         		}
            //         		this.tableData.push(tableItem)
            //         	})
            //         }else{
            //         	throw new Error(res.message)
            //         }
            //     }catch(err){
            //         console.log('获取数据失败', err);
            //     }
            // }
        },
    }
</script>

<style lang="less">
	@import '../style/mixin';
    .table_container{
        padding: 20px;
    }
</style>


