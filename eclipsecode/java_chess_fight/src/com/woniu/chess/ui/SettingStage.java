package com.woniu.chess.ui;

import com.woniu.chess.utils.Global;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SettingStage extends Stage {
	private Button btnOK = new Button("确 定");
	private Button btnCancel = new Button("取 消");
	private TextField txtMyIp = new TextField("localhost");
	private TextField txtMyPort = new TextField("1111");
	private TextField txtOppoIp = new TextField("localhost");
	private TextField txtOppoPort = new TextField("2222");
	private Label lblMyIpMsg = new Label();
	private Label lblMyPortMsg = new Label();
	private Label lblOppoIpMsg = new Label();
	private Label lblOppoPortMsg = new Label();
	
	
	public SettingStage() {
		setTitle("系统设置信息");
        setResizable(false);

        Pane pane = new Pane();
        Label lblMyIP = new Label("我的IP:");
        lblMyIP.setPrefSize(60, 20);
        lblMyIP.setLayoutX(30);
        lblMyIP.setLayoutY(30);

        txtMyIp.setPromptText("请输入我的IP");
        txtMyIp.setLayoutX(100);
        txtMyIp.setLayoutY(30);

        lblMyIpMsg.setPrefWidth(100);
        lblMyIpMsg.setLayoutX(250);
        lblMyIpMsg.setLayoutY(30);

        Label lblMyPort = new Label("我的端口:");
        lblMyPort.setPrefSize(60, 20);
        lblMyPort.setLayoutX(30);
        lblMyPort.setLayoutY(70);

        txtMyPort.setLayoutX(100);
        txtMyPort.setLayoutY(70);
        txtMyPort.setPromptText("请输入我的端口");

        lblMyPortMsg.setLayoutX(250);
        lblMyPortMsg.setLayoutY(70);

        Label lblOppoIp = new Label("对手IP:");
        lblOppoIp.setPrefSize(60, 20);
        lblOppoIp.setLayoutX(30);
        lblOppoIp.setLayoutY(110);

        txtOppoIp.setLayoutX(100);
        txtOppoIp.setLayoutY(110);
        txtOppoIp.setPromptText("请输入对手IP");

        lblOppoIpMsg.setLayoutX(250);
        lblOppoIpMsg.setLayoutY(110);

        Label lblOppoPort = new Label("对手端口:");
        lblOppoPort.setPrefSize(60, 20);
        lblOppoPort.setLayoutX(30);
        lblOppoPort.setLayoutY(150);

        txtOppoPort.setLayoutX(100);
        txtOppoPort.setLayoutY(150);
        txtOppoPort.setPromptText("请输入对手端口:");

        lblOppoPortMsg.setLayoutX(250);
        lblOppoPortMsg.setLayoutY(150);

        btnOK.setLayoutX(110);
        btnOK.setLayoutY(190);
        btnCancel.setLayoutX(180);
        btnCancel.setLayoutY(190);

        btnOK.setDefaultButton(true);
        btnCancel.setCancelButton(true);

        //设置确定处理动作
        btnOK.setOnAction(e ->{
        	//保存配置信息
        	Global.myIp = txtMyIp.getText(); //获取文本框中的值
        	Global.myPort = Integer.parseInt(txtMyPort.getText());
        	Global.oppoIp = txtOppoIp.getText();
        	Global.oppoPort = Integer.parseInt(txtOppoPort.getText());
        	//创建五子棋主界面
        	GameStage gameStage = new GameStage();
        	gameStage.show();
        	//启动线程
        	
        	//关闭当前界面
        	this.close();
        });
        //设置取消处理动作
        btnCancel.setOnAction(e -> {
        	
        });
        
        //添加按钮
        pane.getChildren().addAll(lblMyIP, txtMyIp, lblMyIpMsg, lblMyPort, txtMyPort, lblMyPortMsg, lblOppoIp,
                txtOppoIp, lblOppoIpMsg, lblOppoPort, txtOppoPort, lblOppoPortMsg, btnOK, btnCancel);

        //场景
        Scene scene = new Scene(pane, 400, 250);
        
        //添加场景
        setScene(scene);
	}

}
