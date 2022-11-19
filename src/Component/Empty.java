package Component;

import Controller.ClickController;
import Model.ChessColor;
import Model.ChessboardPoint;
import java.awt.*;

public class Empty extends Grid{
    public Empty(ChessboardPoint chessboardPoint, Point location, int size) {
        //int size 前面是controller listener;
        super(chessboardPoint, location, ChessColor.NONE, size);
        //size 前面是listener;
    }

    @Override
    public boolean canMoveTo(Grid[][] chessboard, ChessboardPoint destination) {
        return false;
    }
}
