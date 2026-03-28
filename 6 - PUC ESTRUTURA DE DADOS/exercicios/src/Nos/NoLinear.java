package Nos;

public class NoLinear {
    int data;
    NoLinear next;

    public NoLinear(int temp) {
        this.data = temp;
    }

    public NoLinear GetNext() {

        return next;

    }

    public void SetNext(NoLinear temp) {

        this.next = temp;

    }

    public int GetData() {

        return data;

    }

    public void SetData(int temp) {
        this.data = temp;
    }

}
