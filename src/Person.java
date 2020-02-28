import java.util.List;

/**
 * @author WangBingchen
 * @date 2020/2/27 上午  10:36
 */
public class Person extends Point {

    private int num;

    private int money = 50;

    private boolean originalRichMan;

    private boolean originalPoor;

    public Person(int num, int x, int y) {
        super(x, y);
        this.num = num;
    }


    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getNum() {
        return num;
    }

    public boolean isOriginalRichMan() {
        return originalRichMan;
    }

    public boolean isOriginalPoor() {
        return originalPoor;
    }

    public void play(PersonPool personPool) {
        List<Person> people = personPool.getPersonList();

        // 标记最初的富人
        if (!originalRichMan && money >= Constants.RICH_STANDARD && personPool.getOriginalRichManCount() < Constants.ORIGINAL_RICH_COUNT) {
            personPool.originalRichManCountIncrease();
            System.out.println("================================================================================================第" + num + "号玩家成为首批富人，当前富人数=======>" + personPool.getOriginalRichManCount());
            originalRichMan = true;
        }

        //标记最初的穷人
        if (!originalPoor && money <= Constants.POOR_STANDARD && personPool.getOriginalPoorCount() < Constants.ORIGINAL_POOR_COUNT) {
            personPool.originalPoorCountIncrease();
            System.out.println("================================================================================================第" + num + "号玩家成为首批穷人，当前穷人数=======>" + personPool.getOriginalPoorCount());
            originalPoor = true;
        }

        if (money > 0) {
            money--;
        }

        int num;
        do {
            num = (int) (Math.random() * Constants.PERSON_COUNT);
        } while (num == this.num);

        for (Person person : people) {
            if (person.num == num) {
                person.money++;
            }
        }
    }
}