import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.Queue;

// ref: https://preview.redd.it/p7xms91zyg221.png?auto=webp&s=a5b4b83dfc62e6fba2031cc461f54e08c3df5eed
// B o n g o C a t ! !
public class Assignment1_65050427_65050242 extends JPanel {
    public static void main(String[] args) {
        Assignment1_65050427_65050242 m = new Assignment1_65050427_65050242();
        JFrame f = new JFrame();
        f.add(m);

        f.setTitle("bongoCat Xmas 🎄");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buffer.createGraphics();

        // พื้นหลัง
        g2.setColor(Color.white);
        g2.fillRect(0, 0, 600, 600);

        g2.setColor(Color.black);
        backgroundXmas(g2);
        treeXmas(g2);
        bodyBongoCat(g2);
        hatXmas(g2);
        tableCat(g2);
        boxPresent(g2, buffer, -10, -10);
        boxPresent(g2, buffer, 170, 20);

        moon(g2);
        star(g2, buffer, 0, 0);
        star(g2, buffer, 30, -130);
        star(g2, buffer, -70, -150);

        // สีท้องฟ้า
        floodfill(buffer, 0, 0, Color.white, Color.decode("#180949"));
        // หิมะ
        for (int i = 0; 30 > i; i++) {
            snow(g2, 0 + randomNumberBetween(0, 60), 0 + randomNumberBetween(0, 200));
        }
        for (int i = 0; 20 > i; i++) {
            snow(g2, 0 + randomNumberBetween(70, 180), 0 + randomNumberBetween(0, 60));
        }
        for (int i = 0; 80 > i; i++) {
            snow(g2, 0 + randomNumberBetween(180, 480), 0 + randomNumberBetween(0, 200));
        }
        // สีในหมวก
        floodfill(buffer, 446, 306, Color.white, Color.decode("#ff0006"));
        floodfill(buffer, 229, 368, Color.white, Color.BLACK);
        floodfill(buffer, 332, 400, Color.white, Color.BLACK);
        // สีหนอกหมวก
        floodfill(buffer, 333, 281, Color.white, Color.decode("#cf0005"));
        // สีโต๊ะ
        floodfill(buffer, 500, 500, Color.white, Color.decode("#7e3f1e"));

        // สีดาวอ่อน
        floodfill(buffer, 136, 106, Color.white, Color.decode("#fff7ac"));
        // สีดาวเข้ม
        floodfill(buffer, 117, 134, Color.white, Color.decode("#fde888"));
        // สีลำต้น
        floodfill(buffer, 125, 370, Color.white, Color.decode("#825128"));

        // สีข้างในใบไม้
        floodfill(buffer, 179, 167, Color.white, Color.decode("#1c7b10"));
        floodfill(buffer, 134, 240, Color.white, Color.decode("#1c7b10"));
        floodfill(buffer, 199, 296, Color.white, Color.decode("#1c7b10"));

        // สีข้างนอกต้นไม้
        floodfill(buffer, 136, 205, Color.white, Color.decode("#1b6911"));
        floodfill(buffer, 193, 276, Color.white, Color.decode("#1b6911"));
        floodfill(buffer, 215, 300, Color.white, Color.decode("#1b6911"));
        floodfill(buffer, 48, 327, Color.white, Color.decode("#1b6911"));

        // สีหัวใจ
        floodfill(buffer, 132, 175, Color.white, Color.decode("#fcdeec"));
        floodfill(buffer, 171, 246, Color.white, Color.decode("#fcdeec"));
        floodfill(buffer, 89, 324, Color.white, Color.decode("#fcdeec"));

        // สีอ่อนพระจันทร์
        floodfill(buffer, 548, 113, Color.white, Color.decode("#fcef91"));
        floodfill(buffer, 514, 113, Color.white, Color.decode("#fed883"));

        // แรงเงาหมวกใสอิอิ
        g2.setColor(Color.white);
        bezierCurve(g2, 477, 287, 488, 288, 493, 295, 497, 304, 5);
        bresenhamLine(g2, 501, 311, 502, 317, 5);

        g.drawImage(buffer, 0, 0, null);
    }

    public void snow(Graphics2D g2, int x, int y) {
        g2.setColor(Color.white);
        bresenhamLine(g2, 5 + x, 8 + y, 8 + x, 11 + y, 3);
    }

    public void boxPresent(Graphics2D g2, BufferedImage buffer, int x, int y) {
        // โบว์
        g2.setColor(Color.decode("#e32239"));
        bezierCurve(g2, 55 + x, 528 + y, 55 + x, 435 + y, 45 + x, 468 + y, 110 + x, 425 + y, 8);
        bezierCurve(g2, 54 + x, 427 + y, 128 + x, 472 + y, 119 + x, 448 + y, 118 + x, 522 + y, 8);
        g2.setColor(Color.black);
        // โครงกล่อง
        bresenhamLine(g2, 28 + x, 465 + y, 28 + x, 517 + y, 4);
        bezierCurve(g2, 28 + x, 517 + y, 33 + x, 524 + y, 70 + x, 540 + y, 87 + x, 541 + y, 4);
        bresenhamLine(g2, 87 + x, 541 + y, 87 + x, 494 + y, 4);
        bezierCurve(g2, 87 + x, 541 + y, 104 + x, 536 + y, 135 + x, 520 + y, 145 + x, 513 + y, 4);
        bresenhamLine(g2, 145 + x, 513 + y, 145 + x, 463 + y, 4);

        bezierCurve(g2, 28 + x, 465 + y, 37 + x, 475 + y, 73 + x, 490 + y, 87 + x, 494 + y, 4);
        bezierCurve(g2, 87 + x, 494 + y, 111 + x, 490 + y, 134 + x, 467 + y, 145 + x, 463 + y, 4);

        bresenhamLine(g2, 28 + x, 465 + y, 23 + x, 462 + y, 4);
        bresenhamLine(g2, 23 + x, 462 + y, 23 + x, 445 + y, 4);
        bresenhamLine(g2, 23 + x, 445 + y, 87 + x, 480 + y, 4);
        bresenhamLine(g2, 87 + x, 480 + y, 87 + x, 494 + y, 4);
        bresenhamLine(g2, 145 + x, 463 + y, 152 + x, 458 + y, 4);
        bresenhamLine(g2, 152 + x, 458 + y, 152 + x, 446 + y, 4);
        bresenhamLine(g2, 87 + x, 480 + y, 152 + x, 446 + y, 4);
        bresenhamLine(g2, 152 + x, 446 + y, 87 + x, 409 + y, 4);
        bresenhamLine(g2, 87 + x, 409 + y, 23 + x, 445 + y, 4);

        floodfill(buffer, 69 + x, 515 + y, Color.white, Color.decode("#56308a"));
        floodfill(buffer, 35 + x, 500 + y, Color.white, Color.decode("#56308a"));

        floodfill(buffer, 110 + x, 502 + y, Color.white, Color.decode("#56308a"));
        floodfill(buffer, 130 + x, 502 + y, Color.white, Color.decode("#56308a"));

        floodfill(buffer, 35 + x, 465 + y, Color.white, Color.decode("#7a31dd"));
        floodfill(buffer, 69 + x, 480 + y, Color.white, Color.decode("#7a31dd"));

        floodfill(buffer, 113 + x, 480 + y, Color.white, Color.decode("#7a31dd"));
        floodfill(buffer, 130 + x, 468 + y, Color.white, Color.decode("#7a31dd"));

        floodfill(buffer, 69 + x, 465 + y, Color.white, Color.decode("#7833df"));
        floodfill(buffer, 80 + x, 430 + y, Color.white, Color.decode("#7833df"));
        floodfill(buffer, 120 + x, 458 + y, Color.white, Color.decode("#7833df"));
        floodfill(buffer, 50 + x, 440 + y, Color.white, Color.decode("#7833df"));

    }

    public void backgroundXmas(Graphics2D g2) {
        bezierCurve(g2, 0, 212, 36, 202, 55, 221, 81, 211, 2);
        bezierCurve(g2, 199, 223, 275, 234, 337, 205, 404, 218, 2);
        bezierCurve(g2, 404, 218, 437, 229, 572, 198, 600, 212, 2);
    }

    public void moon(Graphics2D g2) {
        bezierCurve(g2, 521, 25, 432, 51, 498, 191, 579, 113, 2);
        bezierCurve(g2, 521, 25, 516, 50, 521, 101, 579, 113, 2);

        // ปากพระจันทร์
        bezierCurve(g2, 502, 89, 505, 93, 513, 92, 513, 86, 3);

        // ตาพระจันทร์
        bresenhamLine(g2, 494, 89, 495, 96, 3);
        bresenhamLine(g2, 520, 80, 521, 88, 3);

        g2.setColor(Color.decode("#fcef91"));
        bezierCurve(g2, 517, 30, 507, 35, 495, 83, 505, 89, 2);
        bezierCurve(g2, 507, 93, 507, 104, 540, 133, 555, 126, 2);
    }

    public void star(Graphics2D g2, BufferedImage buffer, int x, int y) {
        g2.setColor(Color.BLACK);
        // กรอบดาว
        bezierCurve(g2, 524 + x, 174 + y, 509 + x, 178 + y, 515 + x, 191 + y, 529 + x, 187 + y, 2);
        bezierCurve(g2, 529 + x, 187 + y, 527 + x, 198 + y, 546 + x, 196 + y, 539 + x, 183 + y, 2);
        bezierCurve(g2, 539 + x, 183 + y, 553 + x, 180 + y, 549 + x, 164 + y, 536 + x, 171 + y, 2);
        bezierCurve(g2, 524 + x, 174 + y, 519 + x, 158 + y, 533 + x, 157 + y, 536 + x, 171 + y, 2);
        // เงา
        g2.setColor(Color.decode("#fcef91"));
        bezierCurve(g2, 536 + x, 171 + y, 527 + x, 176 + y, 529 + x, 181 + y, 539 + x, 183 + y, 2);
        floodfill(buffer, 538 + x, 176 + y, Color.white, Color.decode("#fcef91"));
        floodfill(buffer, 525 + x, 178 + y, Color.white, Color.decode("#fed883"));
    }

    public void bodyBongoCat(Graphics2D g2) {
        // ตัวแมวซ้าย
        bezierCurve(g2, 122, 390, 131, 359, 195, 310, 255, 300, 4);
        bezierCurve(g2, 122, 390, 121, 404, 107, 444, 214, 404, 4);

        // หูแมว
        bezierCurve(g2, 255, 300, 256, 286, 272, 269, 276, 271, 4);
        bezierCurve(g2, 276, 271, 279, 270, 290, 283, 292, 289, 4);

        // ตัวแมวขวา
        bezierCurve(g2, 445, 422, 451, 431, 456, 464, 456, 470, 4);
        bezierCurve(g2, 340, 429, 295, 477, 352, 482, 411, 456, 4);

        // ปากแมว
        bezierCurve(g2, 251, 372, 248, 377, 256, 392, 269, 374, 4);
        bezierCurve(g2, 269, 374, 265, 380, 282, 397, 287, 386, 4);

        // ตาแมวขวา
        bezierCurve(g2, 326, 398, 331, 383, 340, 390, 340, 399, 4);
        bezierCurve(g2, 326, 398, 322, 412, 336, 414, 340, 399, 4);

        // ตาแมวซ้าย
        bezierCurve(g2, 220, 368, 222, 355, 237, 351, 237, 368, 4);
        bezierCurve(g2, 220, 368, 222, 381, 235, 379, 237, 368, 4);

    }

    public void tableCat(Graphics2D g2) {
        bresenhamLine(g2, 0, 360, 122, 392, 4);
        bresenhamLine(g2, 199, 410, 331, 439, 4);
        bresenhamLine(g2, 411, 457, 600, 505, 4);
    }

    public void treeXmas(Graphics2D g2) {
        g2.setColor(Color.decode("#714e19"));
        bresenhamLine(g2, 107, 388, 107, 355, 5);

        // ใบไม้ชั้นล่าง
        bezierCurve(g2, 145, 357, 142, 365, 118, 364, 103, 352, 4);
        bezierCurve(g2, 103, 352, 91, 359, 50, 356, 40, 332, 4);
        bezierCurve(g2, 40, 332, 55, 295, 66, 276, 70, 274, 4);
        bezierCurve(g2, 224, 307, 219, 294, 213, 283, 206, 275, 4);

        // ใบไม้ชั้นกลาง
        bezierCurve(g2, 56, 262, 57, 270, 85, 286, 107, 274, 4);
        bezierCurve(g2, 107, 274, 127, 291, 150, 291, 166, 278, 4);
        bezierCurve(g2, 166, 278, 180, 288, 216, 274, 217, 262, 4);
        bezierCurve(g2, 217, 262, 210, 232, 192, 212, 184, 203, 4);
        bezierCurve(g2, 56, 262, 58, 243, 80, 206, 87, 203, 4);

        // ใบไม้ชั้นบน
        bezierCurve(g2, 72, 190, 74, 201, 101, 213, 113, 204, 4);
        bezierCurve(g2, 72, 190, 78, 170, 100, 138, 109, 133, 4);
        bezierCurve(g2, 113, 204, 126, 216, 151, 214, 159, 201, 4);
        bezierCurve(g2, 159, 201, 183, 210, 203, 195, 201, 188, 4);
        bezierCurve(g2, 201, 188, 194, 171, 173, 139, 163, 129, 4);

        // หัวใจ
        bezierCurve(g2, 130, 172, 116, 160, 102, 180, 135, 191, 4);
        bezierCurve(g2, 130, 172, 137, 152, 156, 168, 135, 191, 4);

        bezierCurve(g2, 173, 243, 168, 228, 141, 239, 171, 262, 4);
        bezierCurve(g2, 173, 243, 184, 226, 200, 250, 171, 262, 4);

        bezierCurve(g2, 93, 318, 89, 295, 60, 321, 94, 337, 4);
        bezierCurve(g2, 93, 318, 101, 295, 121, 321, 94, 337, 4);

        // ดาว
        bezierCurve(g2, 136, 133, 98, 162, 109, 129, 113, 114, 4);
        bezierCurve(g2, 136, 133, 165, 152, 171, 144, 155, 115, 4);
        bezierCurve(g2, 155, 115, 175, 107, 190, 88, 148, 90, 4);
        bezierCurve(g2, 148, 90, 140, 49, 128, 61, 123, 90, 4);
        bezierCurve(g2, 123, 90, 86, 90, 94, 104, 113, 114, 4);

        g2.setColor(Color.decode("#FFF7AC"));
        // ในดาว
        bezierCurve(g2, 129, 95, 134, 73, 140, 74, 145, 96, 2);
        bezierCurve(g2, 129, 95, 104, 95, 106, 100, 120, 110, 2);
        bezierCurve(g2, 120, 110, 108, 134, 120, 136, 133, 124, 2);
        bezierCurve(g2, 133, 124, 159, 140, 153, 129, 148, 113, 2);
        bezierCurve(g2, 148, 113, 171, 99, 162, 97, 145, 96, 2);

        g2.setColor(Color.decode("#1c7b10"));
        // ในใบไม้ชั้นบน
        bezierCurve(g2, 110, 146, 84, 173, 69, 200, 120, 196, 2);
        bezierCurve(g2, 164, 143, 181, 164, 211, 206, 153, 193, 2);
        bezierCurve(g2, 120, 196, 129, 204, 146, 201, 153, 193, 2);

        // ในใบไม้ชั้นกลาง
        bezierCurve(g2, 93, 210, 44, 274, 73, 272, 111, 268, 2);
        bezierCurve(g2, 178, 207, 192, 229, 244, 279, 160, 273, 2);
        bezierCurve(g2, 111, 268, 122, 284, 153, 281, 160, 273, 2);

        // ในใบไม้ชั้นล่าง
        bezierCurve(g2, 78, 280, 38, 346, 60, 339, 109, 344, 2);
        bezierCurve(g2, 197, 282, 206, 290, 209, 303, 213, 310, 2);
        bezierCurve(g2, 109, 344, 118, 350, 151, 352, 164, 339, 2);

        g2.setColor(Color.black);
    }

    public void hatXmas(Graphics2D g2) {
        // หมวกคริสต์มาส
        bezierCurve(g2, 442, 423, 419, 371, 340, 315, 292, 313, 2);
        bezierCurve(g2, 292, 313, 285, 295, 305, 276, 304, 281, 2);
        bezierCurve(g2, 304, 281, 312, 281, 320, 285, 323, 287, 2);
        bezierCurve(g2, 323, 287, 352, 241, 435, 237, 499, 288, 2);
        bezierCurve(g2, 499, 288, 511, 300, 514, 332, 510, 352, 2);

        bezierCurve(g2, 510, 352, 529, 361, 526, 394, 499, 395, 2);
        bezierCurve(g2, 499, 395, 465, 388, 475, 352, 494, 350, 2);

        bezierCurve(g2, 510, 352, 506, 349, 500, 348, 494, 350, 2);

        bezierCurve(g2, 494, 350, 489, 326, 483, 326, 484, 324, 2);
        bezierCurve(g2, 484, 324, 474, 326, 459, 365, 454, 385, 2);
        bezierCurve(g2, 323, 287, 339, 296, 399, 300, 463, 400, 2);
        bezierCurve(g2, 463, 400, 466, 406, 450, 427, 442, 423, 2);

        // ในหมวก
        g2.setColor(Color.decode("#cf0005"));
        bezierCurve(g2, 377, 309, 351, 275, 312, 293, 403, 252, 2);

        g2.setColor(Color.black);

    }

    public void bezierCurve(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int size) {
        for (int i = 0; i <= 1000; i++) {

            double t = i / 1000.0;

            int x = (int) (Math.pow((1 - t), 3) * x1 +
                    3 * t * Math.pow((1 - t), 2) * x2 +
                    3 * Math.pow(t, 2) * (1 - t) * x3 +
                    Math.pow(t, 3) * x4);

            int y = (int) (Math.pow((1 - t), 3) * y1 +
                    3 * t * Math.pow((1 - t), 2) * y2 +
                    3 * Math.pow(t, 2) * (1 - t) * y3 +
                    Math.pow(t, 3) * y4);

            plot(g, x, y, size);
        }
    }

    public int randomNumberBetween(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public void bresenhamLine(Graphics g, int x1, int y1, int x2, int y2, int size) {
        double dx = Math.abs(x2 - x1);
        double dy = Math.abs(y2 - y1);

        double sx = (x1 < x2) ? 1 : -1;
        double sy = (y1 < y2) ? 1 : -1;

        boolean isSwap = false;
        if (dy > dx) {
            double dd = dx;
            dx = dy;
            dy = dd;
            isSwap = true;
        }
        double D = 2 * dy - dx;
        double x = x1;
        double y = y1;
        for (int i = 1; i < dx; i++) {
            plot(g, (int) x, (int) y, size);
            if (D >= 0) {
                if (isSwap) {
                    x += sx;
                } else {
                    y += sy;
                }
                D -= 2 * dx;
            }
            if (isSwap) {
                y += sy;
            } else {
                x += sx;
            }
            D += 2 * dy;
        }
    }

    public BufferedImage floodfill(BufferedImage m, int x, int y, Color targetColor, Color replacementColor) {
        Graphics2D g2 = m.createGraphics();
        Queue<Point> q = new LinkedList<Point>();

        if (m.getRGB(x, y) == targetColor.getRGB()) {
            g2.setColor(replacementColor);
            plot(g2, x, y, 1);
            q.add(new Point(x, y));
        }
        while (!q.isEmpty()) {
            Point p = q.poll();

            // south
            if (p.y < 600 && m.getRGB(p.x, p.y + 1) == targetColor.getRGB()) {
                g2.setColor(replacementColor);
                plot(g2, p.x, p.y + 1, 1);
                q.add(new Point(p.x, p.y + 1));
            }
            // north
            if (p.y > 0 && m.getRGB(p.x, p.y - 1) == targetColor.getRGB()) {
                g2.setColor(replacementColor);
                plot(g2, p.x, p.y - 1, 1);
                q.add(new Point(p.x, p.y - 1));
            }
            // east
            if (p.x < 600 && m.getRGB(p.x + 1, p.y) == targetColor.getRGB()) {
                g2.setColor(replacementColor);
                plot(g2, p.x + 1, p.y, 1);
                q.add(new Point(p.x + 1, p.y));
            }
            // west
            if (p.x > 0 && m.getRGB(p.x - 1, p.y) == targetColor.getRGB()) {
                g2.setColor(replacementColor);
                plot(g2, p.x - 1, p.y, 1);
                q.add(new Point(p.x - 1, p.y));
            }
        }
        return m;

    }

    public void plot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);
    }
}
