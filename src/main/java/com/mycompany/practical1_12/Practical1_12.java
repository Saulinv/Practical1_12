

package com.mycompany.practical1_12;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;


public class Practical1_12 {

    public static void main(String[] args) {
        System.out.println("Practical 1.12 Saulin Ivan RIBO-01-22 Variant 4");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные о растении:");

        System.out.print("Название: ");
        String name = scanner.nextLine();

        System.out.print("Вид: ");
        String species = scanner.nextLine();

        System.out.print("Цвет: ");
        String color = scanner.nextLine();

        System.out.print("Высота: ");
        Integer height = scanner.nextInt();

        System.out.print("В помещении? (true/false): ");
        boolean isIndoor = scanner.nextBoolean();

        Plant plant = new Plant(name, species, color, height, isIndoor);

        // Сохранение объекта в файл в отдельном потоке с переменной th
        Thread th = new Thread(() -> {
            try {
                savePlant(plant);
            } catch (IOException ex) {
                ex.getMessage();
            }
        });
        th.start();
    }

    private static void savePlant(Plant plant) throws IOException {
        String filename = "C:\\JavaPara\\plant.ser"; // Имя файла и путь сохранения
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(plant);
        }
        System.out.println("Растение сохранено в файл: " + filename);
    }
    }

