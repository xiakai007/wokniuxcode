package com.woniu.chess.ui;

import java.util.ArrayList;
import java.util.List;

import com.woniu.chess.entity.Chess;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class GameStage extends Stage {
	private int margin = 50; // 空白
	private int gap = 40; // 间距
	private int size = 15; // 棋盘大小
	private int width = 660; // 宽
	private int height = 700; // 高
	// 按钮宽，高，间距
	private int btnWith = 80, btnHeight = 40, btnGap = 40;
	// 记录游戏是否结束
	private boolean gameOver = false;
	// 存放棋子状态
	private List<Chess> chessList = new ArrayList<>();
	// 控制棋子颜色， 默认黑色
	private boolean isBlack = true;
	private boolean replay = true; // 默认可以悔棋
	private Pane pane = null; // 面板

	public GameStage() {
		setTitle("蜗牛五子棋");
		setResizable(false);

		// 绘制面板
		pane = drawPane();

		// 绘制棋盘
		drawLine(pane);

		// 绘制按钮
		drawButton(pane);

		// 创建场景
		Scene scene = new Scene(pane, width, height);
		setScene(scene);

		// 设置场景 ---
	}

	/**
	 *  绘制按钮
	 * @param pane
	 */
	private void drawButton(Pane pane) {
		// 新局
		Button btnNew = new Button("新局");
		btnNew.setPrefSize(btnWith, btnHeight);
		btnNew.setLayoutX(margin);
		btnNew.setLayoutY(margin + (gap * (size - 1)) + margin / 2);
		btnNew.setOnAction(e -> {
		});

		// 悔棋 --- btnBack
		Button btnBack = new Button("悔棋");
		btnBack.setPrefSize(btnWith, btnHeight);
		btnBack.setLayoutX(margin + btnWith + gap);
		btnBack.setLayoutY(margin + (gap * (size - 1)) + margin / 2);
		btnBack.setOnAction(e -> {
		});

		// 保存 --- btnSave
		Button btnSave = new Button("保存");
		btnSave.setPrefSize(btnWith, btnHeight);
		btnSave.setLayoutX(margin + btnWith * 2 + gap * 2);
		btnSave.setLayoutY(margin + (gap * (size - 1)) + margin / 2);
		btnSave.setOnAction(e -> {
		});

		// 打谱 --- btnReturn
		Button btnReturn = new Button("打谱");
		btnReturn.setPrefSize(btnWith, btnHeight);
		btnReturn.setLayoutX(margin + btnWith * 3 + gap * 3);
		btnReturn.setLayoutY(margin + (gap * (size - 1)) + margin / 2);
		btnReturn.setOnAction(e -> {
		});

		// 退出 --- btnExit
		Button btnExit = new Button("退出");
		btnExit.setPrefSize(btnWith, btnHeight);
		btnExit.setLayoutX(margin + btnWith * 4 + gap * 4);
		btnExit.setLayoutY(margin + (gap * (size - 1)) + margin / 2);
		btnExit.setOnAction(btnExitEvent -> {
		});
		pane.getChildren().addAll(btnNew, btnBack, btnSave, btnReturn, btnExit);
	}

	/**
	 *  绘制棋盘
	 * @param pane
	 */
	private void drawLine(Pane pane) {
		// 绘制横线
		for (int i = 0; i < size; i++) { // 60
			Line line = new Line(margin, margin + (gap * i), margin + gap * (size - 1), margin + (gap * i));
			pane.getChildren().addAll(line);
		}

		// 绘制竖线
		for (int i = 0; i < size; i++) {
			Line line = new Line(margin + (gap * i), margin, margin + (gap * i), margin + gap * (size - 1));
			pane.getChildren().addAll(line);
		}

	}

	/**
	 * 绘制面板
	 * @return
	 */
	private Pane drawPane() {
		Pane pane = new Pane();
		// 背景
		pane.setBackground(new Background(new BackgroundFill(Color.BLANCHEDALMOND, null, null)));

		// 绑定事件
		pane.setOnMouseClicked(e -> {
			

		});
		return pane;
	}

}
