package Component;

import Model.ChessColor;
import Model.ChessboardPoint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
/**
 * 这个类是一个抽象类，主要表示8*4棋盘上每个格子的棋子情况。
 * 有两个子类：
 * 1. EmptySlotComponent: 空棋子
 * 2. ChessComponent: 表示非空棋子
 */
public abstract class Grid extends JComponent {

    private static final Color squareColor = new Color(250, 220, 190);
    protected static int spacingLength;
    protected static final Font CHESS_FONT = new Font("Rockwell", Font.BOLD, 36);

    /**
    * chessboardPoint: 表示8*4棋盘中，当前棋子在棋格对应的位置，如(0, 0), (1, 0)等等
    * chessColor: 表示这个棋子的颜色，有红色，黑色，无色三种
    * isReversal: 表示是否翻转
    * selected: 表示这个棋子是否被选中
    */

    private ChessboardPoint chessboardPoint;
    protected ChessColor chessColor;   //有个final来着
    protected boolean isReversal;
    private static boolean selected;
    /**
     * handle click event
     */

    //先不写controller
    //private final ClickController clickController;

    protected Grid(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor,  int size) {

        //int size前面有一个ClickController clickController

        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
        setLocation(location);
        setSize(size, size);
        this.chessboardPoint = chessboardPoint;
        this.chessColor = chessColor;
        this.selected = false;
        //this.clickController = clickController;
        this.isReversal = false;
    }

    public boolean isReversal() {
        return isReversal;
    }

    public void setReversal(boolean reversal) {
        isReversal = reversal;
    }
    public static void setSpacingLength(int spacingLength) {
        Grid.spacingLength = spacingLength;
    }

    public ChessboardPoint getChessboardPoint() {
        return chessboardPoint;
    }

    public void setChessboardPoint(ChessboardPoint chessboardPoint) {
        this.chessboardPoint = chessboardPoint;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * @param another 主要用于和另外一个棋子交换位置
     *                <br>
     *                调用时机是在移动棋子的时候，将操控的棋子和对应的空位置棋子(EmptySlotComponent)做交换
     */

    public void swapLocation(Grid another){
        ChessboardPoint chessboardPoint1 =getChessboardPoint();
        ChessboardPoint chessboardPoint2 =getChessboardPoint();
        Point point1 = getLocation(); //·
        Point point2 = another.getLocation();
        setChessboardPoint(chessboardPoint2);
        setLocation(point2);
        setChessboardPoint(chessboardPoint1);
        setLocation(point1);

    }

    /**
     * @param e 响应鼠标监听事件
     *          <br>
     *          当接收到鼠标动作的时候，这个方法就会自动被调用，调用监听者的onClick方法，处理棋子的选中，移动等等行为。
     */
    @Override
    protected void processMouseEvent(MouseEvent e) {
        super.processMouseEvent(e);
        if (e.getID() == MouseEvent.MOUSE_PRESSED) {
            System.out.printf("Click [%d,%d]\n", chessboardPoint.getX(), chessboardPoint.getY());
            //ClickController.onClick(this);
        }
    }

    /**
     * @param chessboard  棋盘
     * @param destination 目标位置，如(0, 0), (0, 1)等等
     * @return this棋子对象的移动规则和当前位置(chessboardPoint)能否到达目标位置
     * <br>
     * 这个方法主要是检查移动的合法性，如果合法就返回true，反之是false。
     */

    //todo: Override this method for Cannon
    public boolean canMoveTo(Grid[][] chessboard, ChessboardPoint destination) {
        Grid destinationChess = chessboard[destination.getX()][destination.getY()];
        return destinationChess.isReversal|| destinationChess instanceof Empty;
        //todo: complete this method
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);
        System.out.printf("repaint chess [%d,%d]\n", chessboardPoint.getX(), chessboardPoint.getY());
        g.setColor(squareColor);
        g.fillRect(1, 1, this.getWidth() - 2, this.getHeight() - 2);
    }

    //填充指定的矩形。矩形的左右边分别在x和x + width - 1处。上下边分别在y和y +高度- 1处。生成的矩形覆盖了一个宽度像素宽，高度像素高的区域。矩形使用图形上下文的当前颜色填充。
    //形参:
    //X -待填充矩形的X坐标。Y -要填充矩形的Y坐标。宽度—要填充的矩形的宽度。高度——要填充矩形的高度。





}



