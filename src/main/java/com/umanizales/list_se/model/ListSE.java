package com.umanizales.list_se.model;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

public class ListSE {
    private Node head;
    private int count;

    public void add(Boy boy)
    {
        if (head != null)
        {
            Node temp = head;
            while (temp != null)
            {
                if (boy.equals(boy)){

                }
                temp = temp.getNext();
            }
        }
        if(head == null)
        {
            head = new Node(boy);
        }
        else
        {
            Node temp = head;
            while(temp.getNext()!=null)
            {
                temp = temp.getNext();
            }
            //El quedo parado en el ultimo
            temp.setNext(new Node(boy));
        }

        count++;
    }

    public void addToStart(Boy boy)
    {
        if ( this.head==null)
        {
            this.head = new Node(boy);
        }
        else
        {
            Node temp= new Node(boy);
            temp.setNext(this.head);
            this.head= temp;
        }
        count++;
    }



    public void invert()
    {
        if (this.head != null){
            ListSE listTemp = new ListSE();
            //Recorrer la lista de principio a fin
            Node temp = this.head;
            while (temp != null)
            {
                listTemp.addToStart(temp.getData());
                temp = temp.getNext();
            }
            this.head = listTemp.getHead();
        }
    }

    public int count()
    {
        int cont=0;
        if (this.head != null){
            //Recorrer la lista de principio a fin
            Node temp = this.head;

            while (temp != null)
            {
                cont++;
                temp = temp.getNext();
            }
        }
        return cont;
    }

    public List<Boy> list()
    {
        if(this.head!=null)
        {
            Node temp = this.head;
            List<Boy> list = new ArrayList<>();
            while (temp != null)
            {
                list.add(temp.getData());
                temp = temp.getNext();
            }
            return list;
        }
        return null;
    }

    public void changeXtremes()
    {
        if (this.head!=null && this.head.getNext()!=null)
        {
            //Sacar al niño del head
            Boy start= this.head.getData();
            Node temp = head;
            while(temp.getNext()!=null)
            {
                temp = temp.getNext();
            }
            //temp está ubicado en el ulitmo niño
            this.head.setData(temp.getData());
            temp.setData(start);
        }
    }

    //Eliminar

    public boolean delete(String identification)
    {
        if(this.head != null)
        {
            if (this.head.getData().equals(identification))
            {
                this.head = this.head.getNext();
            }
            else
            {
                Node temp = this.head;
                while(temp != null)
                {
                    if (temp.getNext().getData().getIdentification().equals(identification))
                    {
                        temp.setNext(temp.getNext().getNext());
                    }
                    break;
                }
                temp = temp.getNext();
            }
        }
        return false;
    }

    //dadas dos posiciones cambiar los niños de lugar

    //validacion de no repetir niños

    //Realizar un metodo que reciba como parametro el genero del niño y me liste los niños de dicho genero

    public List<Boy> listGender(String gender)
    {
        if(this.head!=null)
        {
            Node temp = this.head;
            List<Boy> list = new ArrayList<>();
            while (temp != null)
            {
                if (gender.equals(temp.getData().getGender()))
                {
                    list.add(temp.getData());
                }
                temp = temp.getNext();
            }
            return list;
        }
        return null;
    }

    //un metodo que reciba como párametro un genero y todos los niños de dicho genero queden de primeros en la lista

    public List<Boy> listGenderFirst(String gender)
    {
        if (this.head != null){
            ListSE listTemp = new ListSE();
            //Recorrer la lista de principio a fin
            Node temp = this.head;
            while (temp != null)
            {
                if (gender.equals(temp.getData().getGender()))
                {
                    listTemp.addToStart(temp.getData());
                }
                temp = temp.getNext();
            }

            this.head = listTemp.getHead();
        }
        return null;
    }

    //un metodo que cuando lo llame intercale los niños por genero

    public List<Boy> listIntervalsGender(String gender)
    {
        if (this.head != null)
        {
            Node temp = this.head;
            List<Boy> list = new ArrayList<>();
            while(temp != null)
            {
                if (gender.equals(temp.getData().getGender())){
                    list.add(temp.getData());
                }
                temp = temp.getNext();
                list.add(temp.getData());
            }
            return list;
        }
        return null;
    }
}
