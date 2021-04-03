package com.woniu.chess.main;

import com.woniu.chess.ui.GameStage;
import com.woniu.chess.ui.SettingStage;
import com.woniu.chess.utils.ChessMode;
import com.woniu.chess.utils.Global;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChessMain extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//设置标题
		primaryStage.setTitle("蜗牛五子棋对战版");
		//不可改变大小
		primaryStage.setResizable(false);
		//设置按钮
		Button btnSingle = new Button("单机版");
		btnSingle.setPrefSize(100, 100);
		btnSingle.setLayoutX(100);
		btnSingle.setLayoutY(50);
		btnSingle.setOnAction(e ->{
			//区分游戏版本，目的是否通信
			Global.mode = ChessMode.SINGLE;
			//创建五子棋主界面
			GameStage gameStage = new GameStage();
			//关闭当前界面
//			primaryStage.close();
		});
		Button btnFight = new Button("对战版");
		btnFight.setPrefSize(100, 100);
		btnFight.setLayoutX(250);
		btnFight.setLayoutY(50);
		btnFight.setOnAction(e->{
			//区分游戏版本，目的是否通信
			Global.mode = ChessMode.FIGHT;
			//创建设置参数Stage(settingStage)
			SettingStage settingStage = new SettingStage();
			settingStage.show();
			//关闭当前Stage
			primaryStage.close();
		});
		//创建面板
		Pane pane = new Pane();
		pane.setBackground(new Background(new BackgroundFill(Color.BLANCHEDALMOND, null, null)));
		pane.getChildren().addAll(btnSingle,btnFight);
		//场景
		Scene scene = new Scene(pane,400,200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}

}
