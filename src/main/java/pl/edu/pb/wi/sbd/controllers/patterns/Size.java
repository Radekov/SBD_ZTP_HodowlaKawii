package pl.edu.pb.wi.sbd.controllers.patterns;

import java.util.List;

/**
 * Created by qwerte on 2017-01-17.
 */
public class Size {
    int size;
    List<InterfaceChangeSize> inter;

    public void register(InterfaceChangeSize a){
        inter.add(a);
    }

    public void unregister(InterfaceChangeSize a){
        inter.remove(a);
    }

    public void update(boolean a){
        if( a && size < 64){
            inter.forEach(i->i.changeSize(++size));
        } else {
            if( size > 10){
                inter.forEach((i->i.changeSize(--size)));
            }
        }
    }
}
