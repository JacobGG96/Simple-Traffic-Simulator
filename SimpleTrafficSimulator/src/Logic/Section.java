/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;
/**
 *
 * @author gustavo
 */
public class Section {
    
    private String _id;
    private int _direction;
    private int _radius;

    public Section() {
    }

    /**
     * 
     * @return 
     */
    public String getId() {
        return _id;
    }

    /**
     * 
     * @return 
     */
    public int getDirection() {
        return _direction;
    }

    /**
     * 
     * @return 
     */
    public int getRadius() {
        return _radius;
    }

    /**
     * 
     * @param pId 
     */
    public void setId(String pId) {
        this._id = pId;
    }

    /**
     * 
     * @param pDirection 
     */
    public void setDirection(int pDirection) {
        this._direction = pDirection;
    }

    /**
     * 
     * @param pRadius 
     */
    public void setRadius(int pRadius) {
        this._radius = pRadius;
    }
    
    
}