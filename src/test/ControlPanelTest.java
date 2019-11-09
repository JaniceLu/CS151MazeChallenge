package test;

import presentation.ControlPanel;

import java.awt.Container;
import javax.swing.JFrame;

import business.Maze;


/**
 * Change History:
 * 11/7/2019 - JL: created test class for ControlPanel and MazeController
 */
public class ControlPanelTest{

    public static void main(String[] args) {
        Maze maze = new Maze();
        ControlPanel controlPanel = new ControlPanel(maze);
        JFrame controlPanelFrame = new JFrame();
        controlPanelFrame.getContentPane().add(controlPanel);
        controlPanelFrame.setSize(400,800);
        controlPanelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlPanelFrame.setVisible(true);
    }
}