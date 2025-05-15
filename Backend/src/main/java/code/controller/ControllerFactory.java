package code.controller;

import code.interfaces.IController;
import code.interfaces.IView;

/**
 * Factory Klasse zur Instanziierung von Controller Objekten.
 * TODO: Konkrete Instanziierung aus Java Properties lesen.
 */
public abstract class ControllerFactory {

    public static IController getInstance(IView view) {
        return new ClientHandler(view);
    }
}
