package GenericsApp2;

/**
 * Класс дженерик, ограничение типа
 */
public class GenericsApp2 {
    public static void main(String[] args) {
        Account[] accounts = new Account[] {new Account(1857),
                                            new Account(2225),
                                            new Account(33232)};

        Bank<Account> bank = new Bank(accounts);
        bank.AccountsInfo();
    }
}

// ограничения универсального типа <T extends IAccount>
class Bank<T extends IAccount> {
    T[] accounts;

    public Bank(T[] accounts) {
        this.accounts = accounts;
    }

    // вывод информации обо всех аккаунтах
    public void AccountsInfo() {
        for(IAccount account : accounts) {
            System.out.println(account.getId());
        }
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