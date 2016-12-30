package GenericsApp3;

/**
 * Класс дженерик, несколько параметров
 */
public class GenericsApp3 {
    public static void main(String[] args) {
        Account account = new Account(21);
        Operation<Account, Integer> operation = new Operation(account, 100);
        operation.getInfo();
    }
}

// использование нескольких универсальных параметров
class Operation<A extends IAccount, S> {
    private A account;
    private S sum;

    public Operation(A account, S sum) {
        this.account = account;
        this.sum = sum;
    }

    public void getInfo() {
        System.out.println(account.getId());
        System.out.println(sum);
    }
}

interface IAccount {
    int getId();
}

class Account implements IAccount {
    private int id;

    public int getId() {
        return this.id;
    }

    Account(int id) {
        this.id = id;
    }
}