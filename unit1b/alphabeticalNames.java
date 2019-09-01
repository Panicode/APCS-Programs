public class alphabeticalNames{
    public static void main(String[] args){
        String names[]={"William","Dylan","Matthew","Macy","Abe","Eric","Zane"};
        for(int i=0;i<names.length;i++){
            for(int j=1;j<(names.length-1);j++){
                if(names[j-1].compareTo(names[j]) > 0){
                    String temp=names[j-1];
                    names[j-1]=names[j];
                    names[j]=temp;
                }
            }
        }
        for(int j=0;j<names.length;j++){System.out.println(names[j]);}
    }
}
