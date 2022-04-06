/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal;

/**
 *
 * @author ASUS
 */
class LetterNotAllowedException extends Exception {
    public LetterNotAllowedException() {
        super();
    }
    
    public LetterNotAllowedException(String message) {
        super(message);
    }
}
