
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="SubtractResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "subtractResult"
})
@XmlRootElement(name = "SubtractResponse")
public class SubtractResponse {

    @XmlElement(name = "SubtractResult")
    protected int subtractResult;

    /**
     * Obt�m o valor da propriedade subtractResult.
     * 
     */
    public int getSubtractResult() {
        return subtractResult;
    }

    /**
     * Define o valor da propriedade subtractResult.
     * 
     */
    public void setSubtractResult(int value) {
        this.subtractResult = value;
    }

}
