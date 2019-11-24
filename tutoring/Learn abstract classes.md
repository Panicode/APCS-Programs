What are abstract classes?
---

Well, to start out, let's find out what an abstract class is used for.

For example:

![Logo](https://i.imgur.com/y4Awcqj.png)

We have an abstract class named `Entities` and three classes that _inherit_ from that class.

Let's say that `Entities` has a variable named `health`

The source code would look like this:
```
abstract class Entities{
    protected int health;
}
```
The `protected` access modifier __restricts usage of the variable to only it's subclasses.__

This code does literally nothing, as there's no other classes to inherit from it.

How do we inheirit a class from this one? With a `extends` keyword, thus accessing the abstract class and developing upon it.

```
abstract class Entities{
    protected int health;
}

class Players extends Entities{
    health=100;
}
```
__Wait! This doesn't work!__

Why doesn't it work? It's because you don't have any setters/getters or anything within a _constructor_ to use the variables.

here's a better example:
```
abstract class Entities{
    protected int health;
    public Entities(int health){
       this.health=health; 
    }
}

class Players extends Entities{
    public Players(){
        super(100);
    }
}
```
There we go! this works perfectly! Let's make a driver class in order to print out the `health` variable.
```
abstract class Entities{
    protected int health;
    public Entities(int health){
       this.health=health; 
    }
}

class Players extends Entities{
    public Players(){
        super(100);
    }
}

public class Driver{
    public static void main(String[] args){
        Entities player = new Players();
        System.out.println(player.health);
    }
}
```

Please note that all of these variables can actually be objects, methods, etc!
