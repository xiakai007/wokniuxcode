package com.woniu.chess.ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.woniu.model.Chess;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MainApp extends Application {
	// 棋盘属性
	private int width = 680;// 宽:2*margin+(size-1)*gap,
	private int height = 690;// 高
	private int margin = 60;// 边界至棋盘线的空白垂距
	private int gap = 40;// 棋盘线间距
	private int size = 15;// 棋盘大小：棋盘横线个数=棋盘竖线个数=size
	private boolean chessColor = true;// 控制棋子颜色
	// 按钮宽和高
	private int btnWidth = 80;
	private int btnHeight = 40;
	// 打谱按钮宽和高;
	private int dpWidth = 35;
	private int dpHeight = 25;
	// 声明棋子数组保存棋子状态信息
	private Chess[] chesses = new Chess[size * size];
	// 输赢标识
	private boolean flagWin = false;
	// 记录打谱步骤
	private int index = 0;
	// 记录打谱时禁止标识
	private boolean isCan = false;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 面板
		Pane pane = new Pane();
		// 设置背景
		pane.setBackground(new Background(new BackgroundFill(Color.CHOCOLATE, null, null)));

		// Line line = new Line(30,30,600,30);
		// Line line2 = new Line(30,60,600,60);
		// 放置到面板上
		// pane.getChildren().addAll(line,line2);
		// 绘制棋盘线
		for (int i = 0; i < size; i++) {// 横线
			Line line = new Line(margin, margin + gap * i, margin + gap * (size - 1), margin + gap * i);
			pane.getChildren().add(line);
		}
		for (int i = 0; i < size; i++) {// 竖线
			Line line = new Line(margin + gap * i, margin, margin + gap * i, margin + gap * (size - 1));
			pane.getChildren().add(line);
		}

		// 响应鼠标的单击事件
		pane.setOnMouseClicked(e -> {
			// 赢棋后禁止下棋
			if (flagWin) {
				return;
			}
			// 打谱禁止下棋
			if (isCan) {
				return;
			}
			// 判断无效位置
			if (e.getX() < margin - gap / 2 || e.getX() >= margin + gap * (size - 1) + gap / 2
					|| e.getY() < margin - gap / 2 || e.getY() >= margin + gap * (size - 1) + gap / 2) {
				return;
			}
			// 确定位置
			// 像素转换为坐标，以棋盘线左上角点为坐标原点
			int xIndex = ((int) e.getX() - margin + gap / 2) / gap;
			int yIndex = ((int) e.getY() - margin + gap / 2) / gap;

			// 判断当前位置是否有棋子
			for (int i = 0; i < chesses.length; i++) {
				if (chesses[i] == null) {
					break;
				}
				if (chesses[i].getX() == xIndex && chesses[i].getY() == yIndex) {
					return;
				}
			}
			// 绘制棋子
			Circle circle = new Circle();
			circle.setCenterX(xIndex * gap + margin);// 将坐标转换为像素位置
			circle.setCenterY(yIndex * gap + margin);
			circle.setRadius(18.0);// 棋子半径
			// 设置颜色
			if (chessColor) {
				circle.setFill(Color.BLACK);
				// chessColor = false;
			} else {
				circle.setFill(Color.WHITE);
				// chessColor = true;
			}
			// 保存棋子状态信息
			Chess chess = new Chess();
			chess.setX(xIndex);
			chess.setY(yIndex);
			chess.setColor(chessColor ? Color.BLACK : Color.WHITE);

			// 将棋子状态信息放入棋子数组中
			for (int i = 0; i < chesses.length; i++) {
				if (chesses[i] == null) {
					chesses[i] = chess;
					break;
				}
			}
			// 将棋子放入面板中
			pane.getChildren().add(circle);
			// 判断输赢
			if (winChess(chess)) {
				flagWin = true;
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("你赢了");
				alert.setContentText("玩家");
				alert.showAndWait();
			}
			// 改变棋子颜色
			chessColor = !chessColor;
		});

		// 按钮设置
		// 新局
		Button btnNew = new Button("新局");
		btnNew.setPrefSize(btnWidth, btnHeight);
		btnNew.setLayoutX(margin);
		btnNew.setLayoutY(margin * 1.5 + (gap * (size - 1)));
		btnNew.setOnAction(e -> {
			// 新局黑棋先行
			chessColor = true;
			// 清空数组
//			chesses = new Chess[size * size];
			Arrays.fill(chesses, null);
			// 输赢标识恢复初始值
			flagWin = false;
			// 清空棋子
			pane.getChildren().removeIf(c -> c instanceof Circle);

		});
		// 悔棋
		Button btnBack = new Button("悔棋");
		btnBack.setPrefSize(btnWidth, btnHeight);
		btnBack.setLayoutX(margin + btnWidth + gap);
		btnBack.setLayoutY(margin * 1.5 + (gap * (size - 1)));
		btnBack.setOnAction(e -> {
			// 悔棋后再下的棋为合理颜色
			chessColor = !chessColor;
			// 赢棋后禁止悔棋
			if (flagWin) {
				return;
			}
			for (int i = 0; i < pane.getChildren().size(); i++) {
				if (pane.getChildren().get(i) instanceof Circle) {
					// 棋子最后少一个
					pane.getChildren().remove(pane.getChildren().size() - 1);
					break;
				}
			}
//			//判断只能删除棋子,从数组判断
//			if(chesses[0]==null) {
//				return;
//			}
//			//棋子最后少一个
//			pane.getChildren().remove(pane.getChildren().size()-1);

			// 数组元素减一
			for (int i = 1; i <= chesses.length; i++) {
				if (chesses[i] == null) {
					chesses[i - 1] = null;
					break;
				}
			}
		});
		// 保存
		Button btnSave = new Button("保存");
		btnSave.setPrefSize(btnWidth, btnHeight);
		btnSave.setLayoutX(margin + btnWidth * 2 + gap * 2);
		btnSave.setLayoutY(margin * 1.5 + (gap * (size - 1)));
		btnSave.setOnAction(e -> {
			// 弹出保存对话框
			FileChooser fc = new FileChooser();
			fc.setTitle("保存棋谱：");
			// 设置后缀名：*.csv
			fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("csv", "*.csv"));
			// 获取文件的名称和路径
			File file = fc.showSaveDialog(primaryStage);
			// 判断是否点击取消按钮
			if (file == null) {
				return;
			}
			// 保存棋谱信息-棋子的坐标和颜色
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
				// 遍历棋子数组，获取棋子信息
				for (int i = 0; i < chesses.length; i++) {
					if (chesses[i] == null) {
						break;
					}
					bw.write(chesses[i].getX() + "," + chesses[i].getY() + "," + chesses[i].getColor());
					bw.newLine();
				}

			} catch (IOException e1) {
				e1.printStackTrace();
			}
			// 清空棋子
			pane.getChildren().removeIf(c -> c instanceof Circle);
			// 清空棋子数组
//			chesses = new Chess[size * size];
			Arrays.fill(chesses, null);
		});
		// 打谱
		Button btnReturn = new Button("打谱");
		btnReturn.setPrefSize(btnWidth, btnHeight);
		btnReturn.setLayoutX(margin + btnWidth * 3 + gap * 3);
		btnReturn.setLayoutY(margin * 1.5 + (gap * (size - 1)));
		btnReturn.setOnAction(e -> {

			// 弹出选择对话框
			FileChooser fc = new FileChooser();
			fc.setTitle("选择棋谱：");
			fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("csv", "*.csv"));
			File file = fc.showOpenDialog(primaryStage);
			// 判断是否点击取消按钮
			if (file == null) {

				return;
			}
			// 清空打谱步骤记录
			index = 0;
			// 清空已绘制的棋子、数组
			pane.getChildren().removeIf(c -> c instanceof Circle);
			Arrays.fill(chesses, null);
			// 锁定棋盘，打谱禁止下棋
			isCan = true;
			// 创建集合保存棋谱中的棋盘信息
			List<Chess> chessList = new ArrayList<>();
			// 读取棋盘信息
			try (BufferedReader br = new BufferedReader(new FileReader(file))) {
				String data;// 9，6，0x000000ff
				while ((data = br.readLine()) != null) {
					// 拆分data
					String[] chessData = data.split(",");
					// 创建对象，封装数据
					Chess chess = new Chess();
					// data转为int类型坐标数据
					chess.setX(Integer.parseInt(chessData[0]));
					chess.setY(Integer.parseInt(chessData[1]));
					chess.setColor(Color.web(chessData[2]));
					// 将对象放入集合中
					chessList.add(chess);
				}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			// 绘制打谱的子按钮
			// 前进">"
			Button btnNext = new Button(">");
			btnNext.setLayoutX(margin + gap * (size - 1) + gap / 2);
			btnNext.setLayoutY(margin + gap * (size - 1) / 2 - gap / 2 - dpHeight);
			btnNext.setPrefSize(dpWidth, dpHeight);
			btnNext.setOnAction(bnEvent -> {
				// 判断打谱">"是否超出集合范围
				if (index == chessList.size()) {
					return;
				}
				// 从棋谱集合中读取棋子信息
				Chess chess = chessList.get(index);
				// 绘制棋子
				Circle circle = new Circle();
				circle.setCenterX(margin + chess.getX() * gap);// 坐标转为像素
				circle.setCenterY(margin + chess.getY() * gap);
				circle.setRadius(18);
				circle.setFill(chess.getColor());
				// 放置到面板上
				pane.getChildren().add(circle);
				index++;

			});
			// 后退"<"
			Button btnPre = new Button("<");
			btnPre.setLayoutX(margin + gap * (size - 1) + gap / 2);
			btnPre.setLayoutY(margin + gap * (size - 1) / 2);
			btnPre.setPrefSize(dpWidth, dpHeight);
			btnPre.setOnAction(bpEvent -> {
				// 判断打谱记录是否为最后一个
				if (index == 0) {
					return;
				}
				// 减少一个棋子
				pane.getChildren().remove(pane.getChildren().size() - 1);
				index--;
			});

			// 打谱退出"×"
			Button btnExi = new Button("×");
			btnExi.setLayoutX(margin + gap * (size - 1) + gap / 2);
			btnExi.setLayoutY(margin + gap * (size - 1) / 2 + gap / 2 + dpHeight);
			btnExi.setPrefSize(dpWidth, dpHeight);
			btnExi.setOnAction(beEvent -> {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.initOwner(primaryStage);
				alert.setTitle("退出打谱");
				alert.setHeaderText("单击确定按钮退出打谱");
				alert.setContentText("请确认退出：");
				Optional<ButtonType> btnType = alert.showAndWait();
				if (btnType.get() == ButtonType.OK) {
					// 清空打谱记录
					index = 0;
					// 清空绘制的棋子
					pane.getChildren().removeIf(c -> c instanceof Circle);
					// 无需清空数组
					// 退出打谱，解除锁定
					isCan = false;
					// 删除打谱的子按钮
					pane.getChildren().removeAll(btnNext, btnPre, btnExi);
					//退出打谱后黑棋先行
					chessColor = true;
				}
			});
			// 将打谱按钮放置面板上
			pane.getChildren().addAll(btnNext, btnPre, btnExi);

		});

		// 退出
		Button btnExit = new Button("退出");
		btnExit.setPrefSize(btnWidth, btnHeight);
		btnExit.setLayoutX(margin + btnWidth * 4 + gap * 4);
		btnExit.setLayoutY(margin * 1.5 + (gap * (size - 1)));
		btnExit.setOnAction(beEvent -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.initOwner(primaryStage);
			alert.setTitle("退出游戏");
			alert.setHeaderText("单击确定按钮退出游戏");
			alert.setContentText("请确认退出：");
			Optional<ButtonType> btnType = alert.showAndWait();
			if (btnType.get() == ButtonType.OK) {
				System.exit(0);
			}
		});

		pane.getChildren().addAll(btnNew, btnBack, btnSave, btnReturn, btnExit);

		// 创建场景
		Scene scene = new Scene(pane, width, height);

		// 设置标题
		primaryStage.setTitle("蜗牛五子棋");

		// 将场景放入舞台
		primaryStage.setScene(scene);
		// 不能改变棋盘大小
		primaryStage.setResizable(false);
		// 显示
		primaryStage.show();

	}

	/**
	 * 判断输赢的方法
	 * 
	 * @param chess
	 * @return
	 */
	private boolean winChess(Chess chess) {
		// x方向
		int countX = 0;
		// x方向，向左
		for (int x = chess.getX() - 1; x >= 0 && x >= chess.getX() - 4; x--) {
			Chess newChess = new Chess();
			newChess.setX(x);
			newChess.setY(chess.getY());
			newChess.setColor(chess.getColor());
			// 从数组中判断颜色是否相同
			if (hasChess(newChess)) {
				countX++;
			} else {
				break;
			}

		}
		// x方向，向右
		for (int x = chess.getX() + 1; x <= size && x <= chess.getX() + 4; x++) {
			Chess newChess = new Chess();
			newChess.setX(x);
			newChess.setY(chess.getY());
			newChess.setColor(chess.getColor());
			// 从数组中判断颜色是否相同
			if (hasChess(newChess)) {
				countX++;
			} else {
				break;
			}

		}
		// y方向
		int countY = 0;
		// y方向，向上
		for (int y = chess.getY() - 1; y >= 0 && y >= chess.getY() - 4; y--) {
			Chess newChess = new Chess();
			newChess.setX(chess.getX());
			newChess.setY(y);
			newChess.setColor(chess.getColor());
			// 从数组中判断颜色是否相同
			if (hasChess(newChess)) {
				countY++;
			} else {
				break;
			}
		}
		// y方向，向下
		for (int y = chess.getY() + 1; y <= size && y <= chess.getY() + 4; y++) {
			Chess newChess = new Chess();
			newChess.setX(chess.getX());
			newChess.setY(y);
			newChess.setColor(chess.getColor());
			// 从数组中判断颜色是否相同
			if (hasChess(newChess)) {
				countY++;
			} else {
				break;
			}

		}
		// 左上角-右下角方向
		int count1 = 0;
		for (int x = chess.getX() - 1, y = chess.getY() - 1; x >= 0 && y >= 0 && x >= chess.getX() - 4
				&& y >= chess.getY() - 4; x--, y--) {
			Chess newChess = new Chess();
			newChess.setX(x);
			newChess.setY(y);
			newChess.setColor(chess.getColor());
			// 从数组中判断颜色是否相同
			if (hasChess(newChess)) {
				count1++;
			} else {
				break;
			}

		}
		for (int x = chess.getX() + 1, y = chess.getY() + 1; x <= size && y <= size && x <= chess.getX() + 4
				&& y <= chess.getY() + 4; x++, y++) {
			Chess newChess = new Chess();
			newChess.setX(x);
			newChess.setY(y);
			newChess.setColor(chess.getColor());
			// 从数组中判断颜色是否相同
			if (hasChess(newChess)) {
				count1++;
			} else {
				break;
			}

		}
		// 右上角-左下角方向
		int count2 = 0;
		for (int x = chess.getX() + 1, y = chess.getY() - 1; x <= size && y >= 0 && x <= chess.getX() + 4
				&& y >= chess.getY() - 4; x++, y--) {
			Chess newChess = new Chess();
			newChess.setX(x);
			newChess.setY(y);
			newChess.setColor(chess.getColor());
			// 从数组中判断颜色是否相同
			if (hasChess(newChess)) {
				count1++;
			} else {
				break;
			}

		}
		for (int x = chess.getX() - 1, y = chess.getY() + 1; x >= 0 && y <= size && x >= chess.getX() - 4
				&& y <= chess.getY() + 4; x--, y++) {
			Chess newChess = new Chess();
			newChess.setX(x);
			newChess.setY(y);
			newChess.setColor(chess.getColor());
			// 从数组中判断颜色是否相同
			if (hasChess(newChess)) {
				count1++;
			} else {
				break;
			}

		}

		if (countX >= 4 || countY >= 4 || count1 >= 4 || count2 >= 4) {
			return true;
		}
		return false;
	}

	/**
	 * 判断棋子颜色是否相同的方法
	 * 
	 * @param newChess
	 * @return
	 */
	private boolean hasChess(Chess newChess) {
		for (int i = 0; i < chesses.length; i++) {
			if (chesses[i] == null) {
				break;
			}
			if (newChess.getX() == chesses[i].getX() && newChess.getY() == chesses[i].getY()
					&& newChess.getColor().equals(chesses[i].getColor())) {
				return true;
			}
		}
		return false;
	}

}
