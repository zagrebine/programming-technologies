package model;

public class GameObject {
    protected int id;
    protected String name;
    protected int x;
    protected int y;


    public GameObject(int id, String name, int x, int y){
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }


}
