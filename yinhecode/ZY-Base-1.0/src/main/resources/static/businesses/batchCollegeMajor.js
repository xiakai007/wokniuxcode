layui.use(['jquery', 'form', 'febs'], function () {
    let $ = layui.jquery,
        febs = layui.febs,
        form = layui.form;

    //查询所有有效批次
    febs.get(ctx + 'college/batchSelect', null, function (data) {
        let list = data.data;
        for (let i = 0; i < list.length; i++) {
            let batch = list[i];
            $("#cboBatch").append(new Option(batch.batchName, batch.id));
        }
        //重新渲染下拉菜单
        form.render("select");
    });

    //查询所有院校
    febs.get(ctx + 'college/collegeSelect', null, function (data) {
        let list = data.data;
        for (let i = 0; i < list.length; i++) {
            let college = list[i];
            $("#cboCollege").append(new Option(college.name, college.id));
        }
        //重新渲染下拉菜单
        form.render("select");
    });

    //院校层次联动
    form.on('select(cboCollege)', function (data) {
        let collegeId = data.value;
        $("#cboLevel").empty();
        $("#cboLevel").append(new Option("", ""));
        $("#cboMajor").empty();
        $("#cboMajor").append(new Option("", ""));
        febs.get(ctx + 'college/levelSelect?collegeId=' + collegeId, null, function (data) {
            let list = data.data;
            for (let i = 0; i < list.length; i++) {
                let level = list[i];
                $("#cboLevel").append(new Option(level.levelName, level.id));
            }
            //重新渲染下拉菜单
            form.render("select");
        });
    })

    //院校层次专业联动
    form.on('select(cboLevel)', function (data) {
        let collegeId = $("#cboCollege").val();
        let levelId = data.value;
        $("#cboMajor").empty();
        $("#cboMajor").append(new Option("", ""));
        febs.get(ctx + 'college/majorSelect?collegeId=' + collegeId + "&levelId=" + levelId, null, function (data) {
            let list = data.data;
            for (let i = 0; i < list.length; i++) {
                let major = list[i];
                $("#cboMajor").append(new Option(major.fullName, major.id));
            }
            //重新渲染下拉菜单
            form.render("select");
        });
    })

})