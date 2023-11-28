package Homework;

public class Homework1 {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial("-8*x^1 - 3*x^2");
        Polynomial p2 = new Polynomial("-19*x^2 + 2*x^3");

        p1.polynomialCoefficients.print();
        p1.polynomialExponents.print();
        p1.print();
        System.out.println();

        p2.polynomialCoefficients.print();
        p2.polynomialExponents.print();
        p2.print();
        System.out.println();

        System.out.println("Addition:");
        Polynomial.addition(p1, p2).print();
        System.out.println();

        System.out.println("Subtraction:");
        Polynomial.subtraction(p1, p2).print();
        System.out.println();

        System.out.println("Multiplication:");
        Polynomial.multiply(p1, p2).print();
        System.out.println();
    }
}

class Polynomial{
    LinkedList polynomialExponents;
    LinkedList polynomialCoefficients;

    Polynomial(){
        polynomialExponents = new LinkedList();
        polynomialCoefficients = new LinkedList();
    }

    Polynomial(String pol){
        polynomialExponents = new LinkedList();
        polynomialCoefficients = new LinkedList();
        if (pol.contains("- ")){
            pol = pol.replace("- ", "+ -");
        }
        String[] terms = pol.split(" \\+ ");
        for(String term : terms){
            String[] p = term.split("\\*");
            polynomialCoefficients.add(Integer.parseInt(p[0]));
            String[] p2 = p[1].split("\\^");
            polynomialExponents.add(Integer.parseInt(p2[1]));
        }
    }

    static Polynomial addition(Polynomial p1, Polynomial p2){
        Polynomial result = new Polynomial();

        Node currentExponent1 = p1.polynomialExponents.head;
        Node currentCoefficient1 = p1.polynomialCoefficients.head;
        Node currentExponent2 = p2.polynomialExponents.head;
        Node currentCoefficient2 = p2.polynomialCoefficients.head;

        while(currentExponent1 != null || currentExponent2 != null){
            if(currentExponent1 == null){
                result.polynomialCoefficients.add(currentCoefficient2.data);
                result.polynomialExponents.add(currentExponent2.data);
                currentExponent2 = currentExponent2.next;
                currentCoefficient2 = currentCoefficient2.next;
            }
            else
                if(currentExponent2 == null){
                    result.polynomialCoefficients.add(currentCoefficient1.data);
                    result.polynomialExponents.add(currentExponent1.data);
                    currentExponent1 = currentExponent1.next;
                    currentCoefficient1 = currentCoefficient1.next;
                }
            else
                if (currentExponent1.data == currentExponent2.data){
                    result.polynomialCoefficients.add(currentCoefficient1.data + currentCoefficient2.data);
                    result.polynomialExponents.add(currentExponent1.data);
                    currentExponent1 = currentExponent1.next;
                    currentCoefficient1 = currentCoefficient1.next;
                    currentExponent2 = currentExponent2.next;
                    currentCoefficient2 = currentCoefficient2.next;
                }
            else
                if (currentExponent1.data < currentExponent2.data){
                    result.polynomialCoefficients.add(currentCoefficient1.data);
                    result.polynomialExponents.add(currentExponent1.data);
                    currentExponent1 = currentExponent1.next;
                    currentCoefficient1 = currentCoefficient1.next;
                }
            else {
                result.polynomialCoefficients.add(currentCoefficient2.data);
                result.polynomialExponents.add(currentExponent2.data);
                currentExponent2 = currentExponent2.next;
                currentCoefficient2 = currentCoefficient2.next;
            }

        }

        return result;
    }

    static Polynomial subtraction(Polynomial p1, Polynomial p2){
        Polynomial result = new Polynomial();

        Node currentExponent1 = p1.polynomialExponents.head;
        Node currentCoefficient1 = p1.polynomialCoefficients.head;
        Node currentExponent2 = p2.polynomialExponents.head;
        Node currentCoefficient2 = p2.polynomialCoefficients.head;

        while(currentExponent1 != null || currentExponent2 != null){
            if(currentExponent1 == null){
                result.polynomialCoefficients.add(-1*currentCoefficient2.data);
                result.polynomialExponents.add(currentExponent2.data);
                currentExponent2 = currentExponent2.next;
                currentCoefficient2 = currentCoefficient2.next;
            }
            else
                if(currentExponent2 == null){
                    result.polynomialCoefficients.add(currentCoefficient1.data);
                    result.polynomialExponents.add(currentExponent1.data);
                    currentExponent1 = currentExponent1.next;
                    currentCoefficient1 = currentCoefficient1.next;
                }
            else
                if (currentExponent1.data == currentExponent2.data){
                result.polynomialCoefficients.add(currentCoefficient1.data - currentCoefficient2.data);
                result.polynomialExponents.add(currentExponent1.data);
                currentExponent1 = currentExponent1.next;
                currentCoefficient1 = currentCoefficient1.next;
                currentExponent2 = currentExponent2.next;
                currentCoefficient2 = currentCoefficient2.next;
            }
            else
                if (currentExponent1.data < currentExponent2.data){
                result.polynomialCoefficients.add(currentCoefficient1.data);
                result.polynomialExponents.add(currentExponent1.data);
                currentExponent1 = currentExponent1.next;
                currentCoefficient1 = currentCoefficient1.next;
            }
            else {
                result.polynomialCoefficients.add(-1*currentCoefficient2.data);
                result.polynomialExponents.add(currentExponent2.data);
                currentExponent2 = currentExponent2.next;
                currentCoefficient2 = currentCoefficient2.next;
            }
        }
        return result;
    }

    static Polynomial multiply(Polynomial p1, Polynomial p2){
        Polynomial result = new Polynomial();
        Polynomial temp = new Polynomial();

        Node currentExponent1 = p1.polynomialExponents.head;
        Node currentCoefficient1 = p1.polynomialCoefficients.head;
        Node currentExponent2 = p2.polynomialExponents.head;
        Node currentCoefficient2 = p2.polynomialCoefficients.head;

        while(currentExponent1 != null){
            temp.polynomialCoefficients.add(currentCoefficient1.data * currentCoefficient2.data);
            temp.polynomialExponents.add(currentExponent1.data + currentExponent2.data);
            if(currentExponent2.next != null) {
                currentExponent2 = currentExponent2.next;
                currentCoefficient2 = currentCoefficient2.next;
            }
            else{
                currentExponent2 = p2.polynomialExponents.head;
                currentCoefficient2 = p2.polynomialCoefficients.head;
                currentExponent1 = currentExponent1.next;
                currentCoefficient1 = currentCoefficient1.next;
                result = addition(result, temp);
                temp = new Polynomial();
            }
        }
        return result;
    }

    String print() {
        Node currentExponent = polynomialExponents.head;
        Node currentCoefficient = polynomialCoefficients.head;
        String result = "";

        while (currentCoefficient != null) {
            if (currentCoefficient == polynomialCoefficients.head){
                if (currentCoefficient.data < 0){
                    System.out.print("-");
                    result += "-";
                }
            }

            if (currentCoefficient.data != 0) {
                if (currentExponent.data == 0) {
                    if (currentCoefficient.data < 0) {
                        System.out.print(-1 * currentCoefficient.data);
                        result += -1 * currentCoefficient.data;
                    }
                    else {
                        System.out.print(currentCoefficient.data);
                        result += currentCoefficient.data;
                    }
                }
                else
                    if (currentExponent.data == 1) {
                        if (currentCoefficient.data == 1 || currentCoefficient.data == -1){
                            System.out.print("x");
                            result += "x";
                        }
                        else
                            if (currentCoefficient.data < 0){
                                System.out.print(-1*currentCoefficient.data + "*x");
                                result += -1*currentCoefficient.data + "*x";
                            }
                            else {
                                System.out.print(currentCoefficient.data + "*x");
                                result += currentCoefficient.data + "*x";
                            }

                    }
                    else {
                        if (currentCoefficient.data == 1 || currentCoefficient.data == -1){
                            System.out.print("x^" + currentExponent.data);
                            result += "x^" + currentExponent.data;
                        }
                        else
                            if (currentCoefficient.data < 0){
                                System.out.print(-1*currentCoefficient.data + "*x^" + currentExponent.data);
                                result += -1*currentCoefficient.data + "*x^" + currentExponent.data;
                            }
                            else {
                                System.out.print(currentCoefficient.data + "*x^" + currentExponent.data);
                                result += currentCoefficient.data + "*x^" + currentExponent.data;
                            }
                    }

            }

            if (currentCoefficient.next != null && currentCoefficient.next.data != 0) {
                if (currentCoefficient.next.data < 0) {
                    System.out.print(" - ");
                    result += " - ";
                } else {
                    System.out.print(" + ");
                    result += " + ";
                }
            }

            currentCoefficient = currentCoefficient.next;
            currentExponent = currentExponent.next;
        }

        System.out.println();
        return result;
    }


}
