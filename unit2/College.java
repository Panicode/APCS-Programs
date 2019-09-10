public class College{
    public static void main(String []args){
        String names[]={"UCLA","CISCO","CALTECH","UCI","USC"};
        String max="";
        for(int i=0;i<names.length;i++){
            System.out.println("Name: "+names[i]+". With: "+names[i].length()+" Characters.");
            if(i!=0){
                if(names[i].length()>names[i-1].length()){
                    max=names[i];
                }
            }
        }
        System.out.println("The longest name is: "+max);
        System.out.println("\n"+"Actually I change my mind, I don't want UCLA.");
        names[0]=null;
        System.out.println("Here's a better list:");
        for(int i=0;i<names.length;i++){
            if(names[i]!=null){
                System.out.println("Name: "+names[i]);
            }
        }
    }
}
