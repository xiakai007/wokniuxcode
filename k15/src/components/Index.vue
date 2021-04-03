<template>
    <div>
        <Header></Header>
        <Recommend></Recommend>
        <Onlinecourse></Onlinecourse>
        <Interaction></Interaction>
        <IndexTeachers></IndexTeachers>
        <Footer></Footer>
    </div>
</template>

<script>
import Header from '@/components/Header'
import Recommend from '@/components/Recommend'
import Onlinecourse from '@/components/Onlinecourse'
import Interaction from '@/components/Interaction'
import IndexTeachers from '@/components/IndexTeachers'
import Footer from '@/components/Footer'
export default {
    components:{
        Header,
        Recommend,
        Onlinecourse,
        Interaction,
        IndexTeachers,
        Footer
    }
}
</script>

<style>
    @import url("../assets/css/reset.css");
    @import url("../assets/css/global.css");
    @import url("../assets/css/web.css");
    @import url("../assets/css/k15.css");
</style>