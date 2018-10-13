package ug.adamtrawinski.javaee.projekt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/about")
public class AboutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html><body>" +
                "<p><b>William Henry Gates III</b> (ur. 28 października 1955 w Seattle) – amerykański informatyk, przedsiębiorca, filantrop oraz współzałożyciel, główny architekt oprogramowania i były prezes zarządu korporacji Microsoft. Podczas swojej kariery w Microsofcie obejmował stanowiska dyrektora generalnego oraz głównego architekta oprogramowania i pozostaje największym indywidualnym udziałowcem przedsiębiorstwa z ponad 9 procentami akcji zwykłych.</p>" +
                "<p>Gates należy do najbardziej znanych przedsiębiorców okresu rewolucji informatycznej. Choć cieszy się powszechnym uznaniem, jego podejście do prowadzenia interesów jest krytykowane jako antykonkurencyjne, co w niektórych przypadkach znalazło potwierdzenie w wyrokach sądowych. Od czasu kiedy zgromadził swoją fortunę, Gates zaangażował się w szereg przedsięwzięć filantropijnych, przeznaczając duże sumy pieniędzy na potrzeby organizacji dobroczynnych i programów badań naukowych poprzez założoną w 2000 r. fundację Billa i Melindy Gatesów. W corocznym rankingu magazynu Forbes (The World’s Billionaires) Gates zajmował w latach 1995–2007 pierwsze miejsce. Szacunkowa wycena majątku Billa Gatesa w 2007 roku sięgała kwoty ponad 58 miliardów dolarów. W 2008 znalazł się na 3. pozycji listy, wyprzedzony przez Warrena Buffetta i Carlosa Slima Helú.</p>" +
                "<p>Według listy najbogatszych ludzi na świecie opublikowanej 11 marca 2009 roku przez magazyn Forbes Bill Gates powrócił w rankingu na pierwszą pozycję. Jego majątek w ciągu roku spadł o 25 miliardów dolarów i wynosi 40 miliardów dolarów. Jeśli wziąć pod uwagę majątek rodzin, rodzina Gatesów zajmuje drugą pozycję, za rodziną Waltonów, spadkobierców Sama Waltona, założyciela sieci handlowej Walmart. W latach 2010–2013 był drugim najbogatszym człowiekiem na świecie (na szczycie zestawienia znajdował się wtedy Carlos Slim Helú), zaś w 2014 roku ponownie wrócił na pierwszą pozycję, z majątkiem w wysokości 76 miliardów dolarów</p>" +
                "Lista systemów Windows:" +
                "<ul>" +
                "<li>Windows 1.01</li>" +
                "<li>Windows 2.03</li>" +
                "<li>Windows 2.11</li>" +
                "<li>Windows 3.0</li>" +
                "<li>Windows 3.1</li>" +
                "<li>Windows For Workgroups 3.1</li>" +
                "<li>Windows NT 3.1</li>" +
                "<li>Windows For Workgroups 3.11</li>" +
                "<li>Windows 3.2 (wydany tylko w języku chińskim)</li>" +
                "<li>Windows NT 3.5</li>" +
                "<li>Windows NT 3.51</li>" +
                "<li>Windows 95</li>" +
                "<li>Windows NT 4.0</li>" +
                "<li>Windows 98</li>" +
                "<li>Windows 98 SE</li>" +
                "<li>Windows 2000</li>" +
                "<li>Windows Me</li>" +
                "<li>Windows XP</li>" +
                "<li>Windows XP 64-bit Edition</li>" +
                "<li>Windows Server 2003</li>" +
                "<li>Windows XP Professional x64 Edition</li>" +
                "<li>Windows Fundamentals for Legacy PCs</li>" +
                "<li>Windows Vista</li>" +
                "<li>Windows Home Server</li>" +
                "<li>Windows Server 2008</li>" +
                "<li>Windows 7</li>" +
                "<li>Windows Server 2008 R2</li>" +
                "<li>Windows Server 2012</li>" +
                "<li>Windows Server 10</li>" +
                "<li>Windows Server 2016</li>" +
                "</ul>" +
                "<p>Źródła:</p>" +
                "<ol>" +
                "<li><a href='https://pl.wikipedia.org/wiki/Bill_Gates' target='_blank'>Bill Gates</a></li>" +
                "<li><a href='https://pl.wikipedia.org/wiki/Microsoft_Windows' target='_blank'>Windows</a></li>" +
                "</ol>" +
                "<a href='./'>Powrót</a>" +
                "</body></html>");
        out.close();
    }
}
