package ru.job4j.enm;

public class CarService {

    public static void main(String[] args) {
        String accepted = "ACCEPTED";
        Status status = Status.valueOf(accepted);
        System.out.println(status);

        Status[] statuses = Status.values();
        for (Status s : statuses) {
            System.out.println(
                    "Status name: " + s.name()
                    + ", Status serial number: " + s.ordinal()
            );
        }

        Status toyota = Status.FINISHED;
        Status volvo = Status.WAITING;
        System.out.println("Status of Toyota: " + toyota);
        System.out.println("Status of Volvo: " + volvo);

        Order order = new Order(1, "Mercedes-Benz GLS", Status.IN_WORK);
        System.out.println(
                "Заказ-наряд №" + order.getNumber()
                + " на автомобиль " + order.getCar()
                + ", статус ремонта: " + order.getStatus().getInfo()
                + ", подробности: " + order.getStatus().getMessage()
        );

        order.setStatus(Status.WAITING);
        System.out.println(
                "Заказ-наряд №" + order.getNumber()
                        + " на автомобиль " + order.getCar()
                        + ", статус ремонта: " + order.getStatus().getInfo()
                        + ", подробности: " + order.getStatus().getMessage()
        );

        order.setStatus(Status.FINISHED);
        System.out.println(
                "Заказ-наряд №" + order.getNumber()
                        + " на автомобиль " + order.getCar()
                        + ", статус ремонта: " + order.getStatus().getInfo()
                        + ", подробности: " + order.getStatus().getMessage()
        );

        OrderRecord order2 = new OrderRecord(2, "Lada Vesta", Status.FINISHED);
        System.out.println("Заказ-наряд №" + order2.number() + " на автомобиль " + order2.car()
                + ", статус ремонта: " + order2.status().getInfo());
    }

}
