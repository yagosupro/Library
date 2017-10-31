package com.bob;

import com.bob.entity.Book;
import com.bob.service.BookException;
import com.bob.service.BookService;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;

/**
 * Created by bob on 24.01.2017.
 */
public class Gui extends JPanel {
    static JTextField nameAutor;
    static JTextField nameBook;
    static JTextField quanityBook;
    private final BookService bookService=new BookService();




    public void mainMunu() {
        final JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(500, 500);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);

        // создаем  панель.
        JPanel pane = new JPanel();
        jf.add(pane);

        // к панели добавляем менеджер GridLayout
        pane.setLayout(new GridLayout(5, 1));

        // к панели добавляем кнопку и устанавливаем для нее менеджер в верхнее расположение.

        JButton addBook = new JButton("Добавить книгу в базу");
        JButton issueBook = new JButton("Выдать книгу");
        JButton returnBook = new JButton("Вернуть книгу");
        JButton delBook = new JButton("Списать книгу");
        JButton addUsers = new JButton("Добавить пользователя");
        pane.add(addBook);
        pane.add(issueBook);
        pane.add(returnBook);
        pane.add(addUsers);
        pane.add(delBook);

        addBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addBook();
                jf.setVisible(false);
            }
        });

        addUsers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                addUsers();
                jf.setVisible(false);
            }
        });



    }

    public void addBook() {
        final JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);

        Box box1 = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel("Автор:");
        nameAutor = new JTextField(15);
        box1.add(nameLabel);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(nameAutor);

// Настраиваем вторую горизонтальную панель (для ввода пароля)
        Box box2 = Box.createHorizontalBox();
        JLabel bookLabel = new JLabel("Книга:");
        nameBook = new JTextField(15);
        box2.add(bookLabel);
        box2.add(Box.createHorizontalStrut(6));
        box2.add(nameBook);

// Настраиваем третью горизонтальную панель (с кнопками)
        Box box4 = Box.createHorizontalBox();
        JButton add = new JButton("Добавить");
        JButton Clear = new JButton("Очистить");
        JButton backToMenu = new JButton("Меню");
        box4.add(Box.createHorizontalGlue());
        box4.add(add);
        box4.add(Box.createHorizontalStrut(12));
        box4.add(Clear);
        box4.add(Box.createHorizontalStrut(12));
        box4.add(backToMenu);

// Настраиваем четвертую горизонтальную панель (с кнопками)
        Box box3 = Box.createHorizontalBox();
        JLabel quanityLabel = new JLabel("Количество:");
        quanityBook = new JTextField(15);
        box3.add(quanityLabel);
        box3.add(Box.createHorizontalStrut(6));
        box3.add(quanityBook);


// Уточняем размеры компонентов
//        nameLabel.setPreferredSize(bookLabel.getPreferredSize());

// Размещаем три горизонтальные панели на одной вертикальной
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box2);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(box3);
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(box4);
        jf.setContentPane(mainBox);
        jf.pack();
        //   jf.setResizable(false);

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//СОЗДАНИЕ КНИГИ И ДОБАВЛЕНИЕ В БАЗУ

                Book b=new Book();
                b.setName_autor(nameAutor.getText());
                b.setName_book(nameBook.getText());
                b.setQuantity_book(Integer.parseInt(quanityBook.getText()));
                try {

                    bookService.add(b);
                } catch (BookException e1) {
                    e1.printStackTrace();
                }
                //// TODO: 25.01.2017 добавить кнопку ок и очистить поля



            }
        });
        Clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                nameAutor.setText("");
                nameBook.setText("");
                quanityBook.setText("");

            }
        });
        backToMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jf.setVisible(false);
                mainMunu();


            }
        });
    }

    public void addUsers() {
        final JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);

        Box box1 = Box.createHorizontalBox();
        JLabel nameLabel = new JLabel("Новый пользователь:");
        nameAutor = new JTextField(15);
        box1.add(nameLabel);
        box1.add(Box.createHorizontalStrut(6));
        box1.add(nameAutor);



// Настраиваем третью горизонтальную панель (с кнопками)
        Box box4 = Box.createHorizontalBox();
        JButton add = new JButton("Добавить");
        JButton Clear = new JButton("Очистить");
        JButton backToMenu = new JButton("Меню");
        box4.add(Box.createHorizontalGlue());
        box4.add(add);
        box4.add(Box.createHorizontalStrut(12));
        box4.add(Clear);
        box4.add(Box.createHorizontalStrut(12));
        box4.add(backToMenu);

// Размещаем три горизонтальные панели на одной вертикальной
        Box mainBox = Box.createVerticalBox();
        mainBox.setBorder(new EmptyBorder(12, 12, 12, 12));
        mainBox.add(box1);
        mainBox.add(Box.createVerticalStrut(12));
        mainBox.add(Box.createVerticalStrut(17));
        mainBox.add(box4);
        jf.setContentPane(mainBox);
        jf.pack();
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//// TODO: 25.01.2017 переделать юзер панель и добавить сервис
                try {
                    new DBWorker().WriteUsers(nameAutor.getText());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });
        backToMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jf.setVisible(false);
                mainMunu();


            }
        });
        Clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                nameAutor.setText("");

            }
        });
    }

}


