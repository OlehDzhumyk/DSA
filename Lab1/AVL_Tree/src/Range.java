public class Range{
    int first_value;
    int second_value;
    Range(int first_value, int second_value){
        this.first_value = first_value;
        this.second_value = second_value;
    }
    public int middle(){
        return (first_value+second_value)/2;
    }
}
