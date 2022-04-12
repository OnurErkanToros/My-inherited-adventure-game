package com.onurerkan.locations.safe;

import com.onurerkan.Game;
import com.onurerkan.Player;
import com.onurerkan.items.Armors.AgirZirh;
import com.onurerkan.items.Armors.Armor;
import com.onurerkan.items.Armors.HafifZirh;
import com.onurerkan.items.Armors.OrtaZirh;
import com.onurerkan.items.Weapons.Kilic;
import com.onurerkan.items.Weapons.Tabanca;
import com.onurerkan.items.Weapons.Tufek;
import com.onurerkan.items.Weapons.Weapon;


public class Toolstore extends NormalLocation {
    public Toolstore(Player player) {
        super(2, player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("*****************************************************");
        System.out.println(this.getPlayer().getName() + " mağazamıza hoşgeldiniz :) sizin için güzel şeylerimiz var!");
        boolean showMenu = true;
        while (showMenu) {
            System.out.print("""
                    1-) Silahlar lütfen.
                    2-) Zırhlar lütfen.
                    3-) Ben gideyim, yine gelirim inşaallah.
                    Seçiminizi yapınız:""");

            int selected = Game.input.nextInt();
            while (selected < 1 || selected > 3) {
                System.out.print("Hatalı giriş yaptınız, tekrar giriniz:");
                selected = Game.input.nextInt();
            }
            switch (selected) {
                case 1 -> {
                    showWeapons();
                    buyWeapon();
                }
                case 2 -> showArmors();
                case 3 -> {
                    System.out.println("Yine bekleriz efendim");
                    showMenu = false;
                    return true;
                }
            }
        }
        return true;
    }

    private void showWeapons() {
        Weapon[] weapons = {new Tabanca(), new Kilic(), new Tufek()};
        showBakiye();
        System.out.println("********************** Silahlar **********************");
        for (Weapon weapon : weapons) {
            System.out.println("ID: " + weapon.getId() + "\t Silah: " + weapon.getWeaponName() + "\t Gücü: " + weapon.getWeaponDamage() + "\t Fiyatı: " + weapon.getPrice());
        }
        System.out.println("Çıkmak için 0 tuşlayın");
        System.out.println("******************************************************");
    }

    private void buyWeapon() {
        System.out.print("Silahınızı seçin: ");
        int selectWeaponID = Game.input.nextInt();
        if (selectWeaponID != 0) {
            Weapon selectWeapon = null;
            while (selectWeaponID < 0 || selectWeaponID > 3) {
                System.out.print("Geçersiz bir seçim yaptınız lütfen tekrar giriniz:");
                selectWeaponID = Game.input.nextInt();
            }
            switch (selectWeaponID) {
                case 1 -> selectWeapon = new Tabanca();
                case 2 -> selectWeapon = new Kilic();
                case 3 -> selectWeapon = new Tufek();
            }
            if (selectWeapon != null & !selectWeapon.getWeaponName().equals(getPlayer().
                    getInventory().getWeapon().getWeaponName())) {
                if (selectWeapon.getPrice() <= this.getPlayer().getCoin()) {
                    int balance = this.getPlayer().getCoin() - selectWeapon.getPrice();
                    int totalDamage = this.getPlayer().getDamage() + selectWeapon.getWeaponDamage();
                    this.getPlayer().setDamage(totalDamage);
                    this.getPlayer().setCoin(balance);
                    System.out.println(selectWeapon.getWeaponName() + " satın alındı." + "\tKalan para: " + balance + "\t Toplam hasar: " + this.getPlayer().getDamage());
                    this.getPlayer().getInventory().setWeapon(selectWeapon);
                } else {
                    System.out.println("Üzgünüm, paranız yetersiz.");
                }
            } else if (selectWeapon.getWeaponName().equals(getPlayer().getInventory().getWeapon().getWeaponName())) {
                System.out.println("Aynı silahtan zaten var!");
            }
        }
        System.out.println("********************************************************");
    }

    private void showArmors() {
        Armor[] armors = {new HafifZirh(), new OrtaZirh(), new AgirZirh()};
        showBakiye();
        System.out.println("********************** Zırhlar **********************");
        for (Armor armor : armors) {
            System.out.println("ID: " + armor.getId() + "\t Zırh: " + armor.getArmorName() + "\t Engelleme: " + armor.getArmorDefence() + "\t Fiyatı: " + armor.getPrice());
        }
        System.out.println("Çıkmak için 0 tuşlayın");
        System.out.println("******************************************************");
        buyArmor(armors);
    }

    private void buyArmor(Armor[] armors) {
        //bilerek buyWeapon ile farklı yaptım
        System.out.println("Zırhınızı seçin: ");
        int selectedArmorID = Game.input.nextInt();
        if (selectedArmorID != 0) {
            while (selectedArmorID < 0 || selectedArmorID > armors.length) {
                System.out.print("Geçersiz bir seçim yaptınız lütfen tekrar giriniz:");
                selectedArmorID = Game.input.nextInt();
            }

            Armor selectedArmor = armors[selectedArmorID - 1];
            if (selectedArmor.getPrice() <= this.getPlayer().getCoin() &
                    !getPlayer().getInventory().getArmor().getArmorName()
                            .equals(selectedArmor.getArmorName())) {
                int balance = this.getPlayer().getCoin() - selectedArmor.getPrice();
                this.getPlayer().setCoin(balance);

                System.out.println(selectedArmor.getArmorName() + " alındı.\tKalan para: " + balance
                        + "\tMevcut korunma: " + selectedArmor.getArmorDefence());

                this.getPlayer().getInventory().setArmor(selectedArmor);
            } else {
                System.out.println("Paranız yetersiz.");
            }
        }
    }

    private void showBakiye() {
        System.out.println("********************** Bakiye **********************");
        System.out.println("Paran: " + this.getPlayer().getCoin());
        System.out.println("****************************************************");
    }
}
