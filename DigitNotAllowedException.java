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
class DigitNotAllowedException extends Exception {
    public DigitNotAllowedException() {
        super();
    }
    
    public DigitNotAllowedException(String message) {
        super(message);
    }     
}
