<template lang="html">
    <div class="fillcontain">
        <head-top></head-top>
        <div class="table_container">
            <el-table
			    :data="tableData"
			    @expand='expand'
                :expand-row-keys='expendRow'
                :row-key="row => row.index"
			    style="width: 100%">
			    <el-table-column type="expand">
			      <template slot-scope="props">
			        <el-form label-position="left" inline class="demo-table-expand">
			          <el-form-item label="用户组" >
			            <span>{{ props.row.user_name }}</span>
			          </el-form-item>
			          <el-form-item label="创建时间">
			            <span>{{ props.row.restaurant_name }}</span>
			          </el-form-item>
			          <el-form-item label="状态">
			            <span>{{ props.row.address }}</span>
			          </el-form-item>
			          <el-form-item label="详细信息">
			            <span>{{ props.row.restaurant_id }}</span>
			          </el-form-item>
			          <el-form-item label="操作">
			            <span>{{ props.row.restaurant_address }}</span>
			          </el-form-item>
			        </el-form>
			      </template>
			    </el-table-column>
			    <el-table-column
			      label="序号"
			      prop="id">
			    </el-table-column>
			    <el-table-column
			      label="用户组"
			      prop="total_amount">
			    </el-table-column>
			    <el-table-column
			      label="创建时间"
			      prop="status">
			    </el-table-column>
                <el-table-column
			      label="状态"
			      prop="status">
			    </el-table-column>
                <el-table-column
			      label="详细信息"
			      prop="status">
			    </el-table-column>
                <el-table-column
			      label="操作"
			      prop="status">
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
    import headTop from '../components/headTop'
    export default {
        data(){
            return {
                tableData: [],
                currentRow: null,
                offset: 0,
                limit: 10,
                count: 0,
                currentPage: 1,
                restaurant_id: null,
                expendRow: [],
            }
        },
    	components: {
    		headTop,
    	},
        created(){
        	this.restaurant_id = this.$route.query.restaurant_id;
            this.initData();
        },
        mounted(){

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
                                order_number:id++
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
                this.getOrders()
            }
            // async getOrders(){
            //     const Orders = await getOrderList({offset: this.offset, limit: this.limit, restaurant_id: this.restaurant_id});
            //     this.tableData = [];
            //     Orders.forEach((item, index) => {
            //         const tableData = {};
            //         tableData.id = item.id;
            //         tableData.total_amount = item.total_amount;
            //         tableData.status = item.status_bar.title;
            //         tableData.user_id = item.user_id;
 			// 		tableData.restaurant_id = item.restaurant_id;
 			// 		tableData.address_id = item.address_id;
            //         tableData.index = index;
            //         this.tableData.push(tableData);
            //     })
            // },
            // async expand(row, status){
            // 	if (status) {
            // 		const restaurant = await getResturantDetail(row.restaurant_id);
	        //     	const userInfo = await getUserInfo(row.user_id);
	        //     	const addressInfo = await getAddressById(row.address_id);

	        //         this.tableData.splice(row.index, 1, {...row, ...{restaurant_name: restaurant.name, restaurant_address: restaurant.address, address: addressInfo.address, user_name: userInfo.username}});
            //         this.$nextTick(() => {
            //             this.expendRow.push(row.index);
            //         })
	        //     }else{
            //         const index = this.expendRow.indexOf(row.index);
            //         this.expendRow.splice(index, 1)
            //     }
            // },
        }
    }
</script>

<style lang="less">
	@import '../style/mixin';
    .table_container{
        padding: 20px;
    }
    .demo-table-expand {
	    font-size: 0;
	}
	.demo-table-expand label {
	    width: 90px;
	    color: #99a9bf;
	}
	.demo-table-expand .el-form-item {
	    margin-right: 0;
	    margin-bottom: 0;
	    width: 50%;
	}
</style>
