package com.howtodoinjava.hibernate.test.dto.Exercitii.Shop;

import com.howtodoinjava.hibernate.test.HibernateUtil;
import com.howtodoinjava.hibernate.test.dto.Exercitii.Person;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.*;

public class ExecutableShop {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();



        System.out.println("Chose your option:");
        System.out.println("Option1:Show all Products");
        System.out.println("Option2:Show products by brand name");
        System.out.println("Option3:Show Products by highest price");
        System.out.println("Option4:Show Products by lowest price");
        System.out.println("Option5:Show Products by highest price and chose the brand you want to");
        System.out.println("Option6:Show Products by lowest price and chose the brand you want to");
        System.out.println("Option7:Create a profile");
        System.out.println("Option8:Buy Products ");
        System.out.println("Option9:Online Order Validation ");
        System.out.println("Option10:Add credit ");
        System.out.println("Option11:Add a review ");
        System.out.println("Option0:Save and exit");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        do {
            if (option == 1) {
                Query query = session.createQuery("from Products");
                List result = query.getResultList();
                System.out.println(result);

            }
            if (option == 2) {
                Scanner scanner1 = new Scanner(System.in);
                String inputBrand = scanner1.nextLine();
                Query query = session.createQuery("from Brand where brandName=:productSearch");
                query.setParameter("productSearch", inputBrand);
                Products productsResultList = (Products) query.getResultList().get(0);
                System.out.println(productsResultList.getBrand());


            }
            if (option == 3) {
                Scanner scanner1 = new Scanner(System.in);
                Double inputPrice = scanner1.nextDouble();
                Query query = session.createQuery("from Product where price>:priceDisplay");
                query.setParameter("priceDisplay", inputPrice);
                List<Products> result = query.getResultList();
                System.out.println(result);

            }
            if (option == 4) {
                Scanner scanner1 = new Scanner(System.in);
                Double inputPrice = scanner1.nextDouble();
                Query query = session.createQuery("from Product where price<:priceDisplay");
                query.setParameter("priceDisplay", inputPrice);
                List<Products> result = query.getResultList();
                System.out.println(result);

            }
            if (option == 5) {
                Scanner scanner1 = new Scanner(System.in);


                Query query = session.createQuery("from Products");
                List<Products> result = (List<Products>) query.getResultList();


                System.out.println("Chose the brand");
                String inputBrandName = scanner1.nextLine();
                Query query1 = session.createQuery("from Brand where brandName=:searchBrand order by price asc");
                query1.setParameter("searchBrand", inputBrandName);
                Brand brandResult = (Brand) query1.getResultList().get(0);


            }
            if (option == 6) {
                Scanner scanner1 = new Scanner(System.in);
                Query query = session.createQuery("from Products");
                List<Products> result = (List<Products>) query.getResultList();


                System.out.println("Chose the brand");
                String inputBrandName = scanner1.nextLine();
                Query query1 = session.createQuery("from Brand where brandName=:searchBrand order by price desc");
                query1.setParameter("searchBrand", inputBrandName);
                Brand brandResult = (Brand) query1.getResultList().get(0);
                String getNameBrand = brandResult.getBrandName();


            }
            if (option == 7) {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Insert Last Name");
                String inputLastName = scanner1.nextLine();
                System.out.println("Insert First Name");
                String inputFirstName = scanner1.nextLine();
                System.out.println("Select Gender");
                String gender = scanner1.nextLine();
                System.out.println("Insert email");
                String email = scanner1.nextLine();
                System.out.println("Insert password");
                String password = scanner1.nextLine();
                Credit test = new Credit();
                Clients clients = new Clients();
                clients.setFirstName(inputFirstName);
                clients.setLastName(inputLastName);
                clients.setGender(gender);
                clients.seteMail(email);
                clients.setPassword(password);
                clients.setCredit(test);
                session.persist(test);

                System.out.println("You want to add your card?Chose 1 to add and 2 to not add");
                int inputCardChoice = scanner.nextInt();
                session.persist(clients);

                if (inputCardChoice == 1) {
                    DataCard dataCard = new DataCard();
                    System.out.println("Insert card code:");
                    int dataCardInput = scanner.nextInt();
                    System.out.println("Insert card name");
                    String dataCarName = scanner.next();
                    System.out.println("Insert cvv");
                    int cvvInput = scanner.nextInt();
                    System.out.println("Insert exp date");
                    int expDateCardInput = scanner.nextInt();
                    dataCard.setCardCode(dataCardInput);
                    dataCard.setCardHolderName(dataCarName);
                    dataCard.setCvv(cvvInput);
                    dataCard.setExpDate(expDateCardInput);
                    clients.setDataCard((DataCard) dataCard);
                    session.persist(dataCard);
                    session.update(clients);


                }
                if (inputCardChoice == 2) {
                    System.out.println("If you want to add in the future your card for on line payments.you need to add it in a separate function");

                }


            }
            if (option == 8) {
                System.out.println("If you want to pay online, you must have credit in your account. " +
                        "If you don't want to add credit to your account, you can pay on cash on delivery");
                String input = scanner.next();
                Query query5 = session.createQuery("from Clients where firstName=: searchName");
                query5.setParameter("searchName", input);
                Clients resultListClientsName = (Clients) query5.getResultList().get(0);
                System.out.println(resultListClientsName + "Found");
                int inputChoseToBuyAnotherProduc;


                List<Products> basketList = new ArrayList<>();
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Search for a product to add to the basketList ");
                String inputProductName = scanner1.nextLine();
                Query query = session.createQuery("from Products where name=:searchProduct");
                query.setParameter("searchProduct", inputProductName);
                Products productListFind = (Products) query.getResultList().get(0);
                System.out.println(productListFind + "has been found");
                basketList.add(productListFind);
                System.out.println("Do you want to buy another product?Chose 1 for yes and 2 for no");
                resultListClientsName.setProductsPrice(basketList);
                int inputChoseToBuyProduct = scanner1.nextInt();

//                This code is the same as the one above
//                Criteria crit = session.createCriteria(Product.class);
//                Criterion price = Restrictions.gt("price",new Double(25.0));
//                crit.setMaxResults(1);
//                Product product = (Product) crit.uniqueResult()


                do {

                    if (inputChoseToBuyProduct == 1) {
                        Scanner scanner11 = new Scanner(System.in);
                        String inputAnotherProduct = scanner11.nextLine();
                        System.out.println("Chose another product too add to the basketList");
                        Query query1 = session.createQuery("from Products where name=:searchProduct");
                        query1.setParameter("searchProduct", inputAnotherProduct);
                        Products productsAnotherListFind = (Products) query1.getResultList().get(0);
                        System.out.println(productsAnotherListFind + "found");
                        basketList.add(productListFind);
                        basketList.add(productsAnotherListFind);
                        Double priceTotalProducts = productListFind.getPrice() + productsAnotherListFind.getPrice();
                        System.out.println(priceTotalProducts + "TOTAL PRICE");


                    }


                    System.out.println("Chose 1 if you want to add other products to the existing ones and 2 if you don't want it");
                    inputChoseToBuyAnotherProduc = scanner1.nextInt();
                    if (inputChoseToBuyAnotherProduc == 1) {
                        System.out.println("Are you sure you want to go back to add products to your list?Chose 1 for that>>>");
                        inputChoseToBuyProduct = scanner.nextInt();

                    }
                    resultListClientsName.setProductsPrice(basketList);
                    session.update(resultListClientsName);
                } while (inputChoseToBuyAnotherProduc != 2);


            }


            //Another Option to add products(i like it more with do while)
//            if (option == 10) {
//                System.out.println("Insert name");
//                String input = scanner.next();
//                Query query = session.createQuery("from Clients where firstName=:searchName");
//                query.setParameter("searchName", input);
//                Clients o = (Clients) query.getResultList().get(0);
//                int number = scanner.nextInt();
//                List<Products> productsList = new ArrayList<>();
//                for (int i = 0; i < number; i++) {
//                    String product = scanner.next();
//                    Query query1 = session.createQuery("FROM Products");
//                    List<Products> resultList = query1.getResultList();
//                    for (Products products : resultList) {
//                        if (products.getName().contains(product) || products.getName().equals(product)) {
//                            productsList.add(products);
//                        }
//                    }
//                }
//                o.setProductsPrice(productsList);
//                session.update(o);
//            }


            if (option == 9) {
                String inputNameSearch = scanner.next();
                Query query = session.createQuery("from Clients where firstName=:searchName");
                query.setParameter("searchName", inputNameSearch);
                Clients resultList = (Clients) query.getResultList().get(0);
                List<Products> productsPrice = resultList.getProductsPrice();
                double sumAllProducts = 0;
                for (Products products : productsPrice) {
                    sumAllProducts += products.getPrice();
                }
                if (resultList.getCredit().getCreditAmount() >= sumAllProducts) {
                    double result = resultList.getCredit().getCreditAmount() - sumAllProducts;
                    Credit credit = resultList.getCredit();
                    credit.setCreditAmount(result);
                    session.update(credit);
                    resultList.setCredit(credit);
                    session.update(resultList);
                    System.out.println("The payment was made successfully");
                } else {
                    System.err.println("Insufficient credit. Please add credit first to validate the order");
                }
            }
            if (option == 10) {
                String inputNameSearch = scanner.next();
                Query query = session.createQuery("from Clients where firstName=:searchName");
                query.setParameter("searchName", inputNameSearch);
                Clients resultList = (Clients) query.getResultList().get(0);
                Query query1 = session.createQuery("from DataCard where cvv=:searchCVV");
                System.out.println("You just need to insert your cvv to add credit to your account");
                int inputCVV = scanner.nextInt();
                query1.setParameter("searchCVV", inputCVV);
                DataCard cvvResult = (DataCard) query1.getResultList().get(0);
                Credit credit = resultList.getCredit();
                double creditInput = scanner.nextDouble();
                credit.setCreditAmount(creditInput);
                session.update(credit);
                session.update(resultList);

            }
            if (option==11){
                System.out.println("Chose a product to add a review and a star:)");
                String inputSearchNameProduct = scanner.next();
                Query query = session.createQuery("from Products where name=:searchName");
                query.setParameter("searchName",inputSearchNameProduct);
                Products resultProductSearchList = (Products) query.getResultList().get(0);
                System.out.println(resultProductSearchList+ "Found:)");
                System.out.println("Please add a review");
                String inputReviewAdd = scanner.next();
                System.out.println("And a star:)");
                Integer inputStar= scanner.nextInt();

                ReviewWithStar reviewWithStar = new ReviewWithStar();
                reviewWithStar.setReview(inputReviewAdd);
                reviewWithStar.setStars(inputStar);
                resultProductSearchList.getReviewWithStars().add(reviewWithStar);
                session.save(resultProductSearchList);
            }


            System.out.println("Choose the option again");


            option = scanner.nextInt();

        } while (option != 0);
        session.getTransaction().commit();
        HibernateUtil.shutdown();


    }
}


