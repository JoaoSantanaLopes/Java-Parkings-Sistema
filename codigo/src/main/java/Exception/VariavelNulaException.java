/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

/**
 *
 * @author Pedro
 */
public class VariavelNulaException extends Exception {
    
    // Construtor padrão
    public VariavelNulaException() {
        super("A variável não pode ser nula.");
    }

    // Construtor com mensagem personalizada
    public VariavelNulaException(String variableName) {
        super("A variável '" + variableName + "' não pode ser nula.");
    }

    // Construtor com mensagem e causa
    public VariavelNulaException(String variableName, Throwable cause) {
        super("A variável '" + variableName + "' não pode ser nula.", cause);
    }
}