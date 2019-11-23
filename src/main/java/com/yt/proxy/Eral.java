package com.yt.proxy;

public class Eral {

    public static void main(String[] args) {
        //从前有个女孩叫王美丽
        Girl girl = new WangMeiLi();

        //王美丽有庞大的家庭，必须征得他家人的同意才行,
        ProxyPeople family = new ProxyPeople(girl);
        
        //他们家庭选出他妈妈作为代理人，只要他妈妈同意就行
        Girl mother = (Girl) family.getInstance();

        //经过他妈妈的同意才能约会
        mother.date();

        System.out.println("=============");
        //经过他妈妈的同意才能去看电影
        mother.watchMovie();


    }
}
