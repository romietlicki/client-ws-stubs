
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="intA" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="intB" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "intA",
    "intB"
})
@XmlRootElement(name = "Subtract")
public class Subtract {

    protected int intA;
    protected int intB;

    /**
     * Obt�m o valor da propriedade intA.
     * 
     */
    public int getIntA() {
        return intA;
    }

    /**
     * Define o valor da propriedade intA.
     * 
     */
    public void setIntA(int value) {
        this.intA = value;
    }

    /**
     * Obt�m o valor da propriedade intB.
     * 
     */
    public int getIntB() {
        return intB;
    }

    /**
     * Define o valor da propriedade intB.
     * 
     */
    public void setIntB(int value) {
        this.intB = value;
    }

}
