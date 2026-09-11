package collections.d09092026.exercicios.exercicio1;

import java.util.ArrayList;

public class MainTestes {
	public static void main(String[] args) {

		
		ArrayList<String> playlist = new ArrayList<>();

		
		playlist.add("Mensageiros da Profecia - Deixa Eu Entrar");
		playlist.add("Mensageiros da Profecia - Relato Dos que Ficaram");
		playlist.add("Mensageiros da Profecia - A Parábola do Reino");
		playlist.add("Mano Sassá e Mensageiros da Profecia - Glórias e Renúncias");
		playlist.add("Mensageiros da Profecia - Perdão A Cura Para o Ódio");
		playlist.add("Biorki - Eu Vi Deus");			
		playlist.add("Templo Soul - Último Dia");
		playlist.add("Provérbio X & APOCALIPSE 16");
		playlist.add("Proverbio X e Pregador Luo Nova Patria");
		playlist.add("Provérbio X - Não Perdi a Minha Fé");
		playlist.add("Provérbio X - Não Perdia Minha Fé, Pt. 2");		
		playlist.add("Provérbio X - Fé");
		playlist.add("Provérbio x ainda há lugar");
		playlist.add("Olhe para Cruz - Uma animação | Raphael Camelo ft. Ananda Keteley");
		playlist.add("DigitalBomb - Foi Na Cruz");
		playlist.add("Oficina G3 - João");
		playlist.add("Mano Sassá - A Noiva e o Cordeiro Ft. Alef");
		playlist.add("Mano Sassá - Amigo do Peito Ft. Karina Carfi");		
		playlist.add("Pregador Luo - OLHOS BONS – Participação Especial Thaiane Seghetto");
		playlist.add("Pregador Luo - Árvore de Bons Frutos | APOCALIPSE 16");	
		playlist.add("Pregador Luo - Único-Incomparável");		
		playlist.add("Pregador Luo - Pai Nosso");		
		playlist.add("Thiagão - Só Tua Graça Me Basta");
		playlist.add("Hillsong - Quem Dizes Que Eu Sou");
		playlist.add("Hillsong - Em Paz");
		playlist.add("Hillsong - EU TAMBÉM (100 BILHÕES X)");
		playlist.add("BARUCH ATA ADONAI ELOHEINU");
		playlist.add("Gadol Elohai by Joshua Aaron");
		playlist.add("Sarah Liberman - Fire of Your");
		playlist.add("Aaron Shust - Daughters of Zion");
		playlist.add("Hebrew Roots Praise and Worship");
		playlist.add("Praise to Our God 5 Concert - Ashuv Eleicha");
		playlist.add("Praise to Our God 5 Concert - Lechu Nerannena LeAdonai (Let us sing to the Lord)");
		playlist.add("Praise to Our God 5 Concert - Gadol Adonai (Great is the Lord)");
		playlist.add("אבא (Aba- Pai) אברהם פריד ( Avraham Frid)");
		playlist.add("Hebrew Worship - תְּהִלִּים 148 - Psalm 148 - Biblical Hebrew");
		playlist.add("Holy Forever in Hebrew | Kadosh Lanetzach - Emanuel Roro");
		playlist.add("Hebrew & Arabic 📜 HOW GREAT IS OUR GOD גדול אלוהי (GADOL ELOHAI) LIVE at the GARDEN TOMB");
		playlist.add("BECAUSE HE LIVES (Hebrew and English!) LIVE at the Garden Tomb | Jerusalem Easter");
		playlist.add("THE BLESSING in Hebrew HA BRACHA הברכה - Official Music Video - Jerusalem, Israel | Joshua Aaron");
		playlist.add("Praises Of Israel - Mizmor KIZ(Psalm 117)");
		playlist.add("ABOVE ALL in Hebrew, Arabic & English (Live Worship, Jerusalem)");
		playlist.add("Skillet - Stars");
		playlist.add("Skillet - Rise");
		playlist.add("Skillet - Not Gonna Die");
		playlist.add("Skillet - Feel Invincible");
		playlist.add("Skillet - Rebirthing");		
		playlist.add("Skillet - Awake And Alive");	
		playlist.add("Skillet - Resistance");	
		playlist.add("Skillet - Whispers In The Dark");
		playlist.add("Skillet - Falling Inside The Black");
		playlist.add("Kutless - What Faith Can Do");
		playlist.add("Kutless - Take Me In");
		playlist.add("Casting Crowns - Set Me Free");
		playlist.add("Ashes Remain - On My Own");
		playlist.add("Ashes Remain - Right Here");
		playlist.add("Linkin Park - Numb");
		playlist.add("Simple Plan - Perfect");
		playlist.add("Red - So Far Away");
		playlist.add("Nickelback - Photograph");
		playlist.add("The Calling - Wherever You Will Go");
		playlist.add("Maroon 5 - Payphone ft. Wiz Khalifa");
		playlist.add("Avril Lavigne - Complicated");		
		
		System.out.println("\nPlaylist: ");
		
		for (String musica : playlist) {
			System.out.println(musica);
		}

		System.out.println("\nQuantidade de músicas: " + playlist.size());
		System.out.println("\nMúsica na terceira posição: " + playlist.get(2));

		playlist.set(playlist.size() - 4, "So Will I - Hillsong (cover) by Genavieve"); // trocar : Nickelback - Photograph
		
		playlist.remove(playlist.size() - 1); // remove essa : Avril Lavigne - Complicated
		
		playlist.add("I Thank God - Maverick City Music (cover) by Genavieve Linkowski");
		playlist.add("Goodness of God - Bethel Music (cover) by Genavieve Linkowski");
		playlist.add("Oceans - Hillsong United (cover) by Genavieve Linkowski | Collab w/ Anthem Worship + @MassAnthem");
		playlist.add("הללויה - הילה בן דוד | HALLELUJAH - L.Cohen & Psalm 150 | Hila Ben David (HALO) - Live Concert 2024");
		playlist.add("A Tua Presença (Eliana Rodrigues) | Música Verbo Sede");
		playlist.add("Medley Confio em Ti + Salmos 23 | Música Verbo Sede");
		playlist.add("Nada Me Falta (Eliezer Rodrigues) | Música Verbo Sede");
		playlist.add("Medley Tens Sido Fiel + Vem de Ti Senhor | Música Verbo Sede");
		playlist.add("TEMPOS DE ABUNDÂNCIA | Gabriel Rodrigues");
		playlist.add("Deus se move (Emylie Rodrigues) | Música Verbo Sede");
		playlist.add("Canção do Céu | Música Verbo Sede");
		playlist.add("Autor do Caminho (Sinach) | Música Verbo Sede");
		playlist.add("DIGNO DE TUDO (Ao Vivo) | Emi Sousa | fhop music");
		playlist.add("SANTO PRA SEMPRE | BRASA CHURCH, BEBEL MELO");
		playlist.add("FAVOR DE DEUS - Emylie Rodrigues (Ao Vivo)");
		playlist.add("ENCHE-ME (Clipe Oficial) | Isaías Saad + Gabriela Rocha");
		playlist.add("Vitorioso És (Bethel Music) | Música Verbo Sede");
		playlist.add("Felipe Rodrigues - Tudo é Perda (Ao Vivo)");
		playlist.add("Julia Vitoria - De Dentro Pra Fora (Live Session)");
		playlist.add("Matheus Emanuel - Bom Demais Para Não Crer ft. Isabella Gomes ( Too Good to Not Believe )");
		playlist.add("Vitorioso És | Gabi Sampaio");
		playlist.add("Pai Nosso | Ibab Celebração");
		playlist.add("GABRIELA ROCHA - ME ATRAIU (AO VIVO)");
		playlist.add("Emylie Rodrigues - Tudo é possível (Ao vivo oficial)");
		playlist.add("Oh Quão Lindo Esse Nome É - Hillsong Em Português");
		playlist.add("Como Estou Tu Me Amas - Hillsong Em Português");
		playlist.add("Way Maker | Jenna Bataller | Worship Moments - Madison Street Worship");
		playlist.add("A ELE A GLÓRIA - Matheus Rizzo & Coral com 1700 vozes Mega Vigília ASP");
		playlist.add("Nada Temerei (Jesus Culture) | Música Verbo Sede");
		playlist.add("Thalles Roberto - DVD - Me Faz Viver");
		playlist.add("Deus Forte – Kleber Lucas");
		playlist.add("Isadora Pompeo - Bênçãos Que Não Têm Fim");
		playlist.add("Heloisa Rosa e Fernandinho - Yeshua");
		playlist.add("Adoração Central - Digno de Tudo / Te Exaltamos (Ao Vivo) | BRAVE");
		playlist.add("MARAVILHADO - NÍVEA SOARES | AO VIVO");
		playlist.add("Minhas Guerras I Brasa Church Music | Liz Johnson");
		playlist.add("Felipe Rodrigues - Primeira Essência - Ministração ao vivo");
		playlist.add("Te Seguirei Até O Fim | Música Verbo Sede");
		playlist.add("Medley Digno de Tudo + Te Exaltamos | Música Verbo Sede");
		playlist.add("Pra Sempre Teu | Música Verbo Sede");
		playlist.add("Ruja o Leão | Música Verbo Sede");
		playlist.add("Sarah Oliveira - Cadeias Quebrar (Ao Vivo) | BRAVE");
		playlist.add("Vou Construir | Música Verbo Sede");
		playlist.add("A Ele a Glória (Diante do Trono) | Música Verbo Sede");
		playlist.add("Eu sei que Tu És Bom | Música Verbo Sede");
		playlist.add("Não Mais escravo - Eliezer Rodrigues (Versão Bethel)");
		playlist.add("Seja Exaltado + Exaltado | Música Verbo Sede");
		playlist.add("Além do Rio Azul | Música Verbo Sede");
		playlist.add("Jeová Jireh | Música Verbo Sede");
		playlist.add("Te agradeço - Lyric Video | Hillsong em Português");
		playlist.add("Fernanda Madaloni - Maranata / Oh Quão Lindo esse Nome É / Pra Sempre (Medley) | BRAVE");
		playlist.add("Digno de Tudo (Ao Vivo) - Fernanda Ferro");
		playlist.add("Ao único + Espírito, enche a minha vida + Consagração - Brasa Church");
		playlist.add("Felipe Rodrigues - Digno É o Senhor - Ministração ao vivo");
		playlist.add("Digno É O Senhor (Ao Vivo) - Lucas Wallas, Kamilla Silva");
		playlist.add("Sozinho Nunca Andarei - Lyric Video | Hillsong Em Português");
		playlist.add("Canção Ao Cordeiro | Música Verbo Sede");
		playlist.add("Tetelestai | Música Verbo Sede");
		playlist.add("Eu Te Agradeço (Maverick City Music) | Música Verbo Sede");
		playlist.add("Medley Tempos de Abundância (Gabriel Rodrigues) + Estamos de pé (Marcos Sales) | Música Verbo Sede");
		playlist.add("Aleluia, Deus é Sempre Bom (Eliezer Rodrigues) | Música Verbo Sede");
		playlist.add("Dias de Elias | Música Verbo Sede");
		playlist.add("Tributo a Yehovah + Te agradeço | Música Verbo Sede");
		playlist.add("Medley Sonhando os sonhos de Deus + Está Escrito | Música Verbo Sede");
		playlist.add("ENTRE A FÉ E A RAZÃO ABRAÃO E ISAQUE");
		playlist.add("Quando Jesus estendeu a sua mão | Música Verbo Sede");
		playlist.add("Não Há Deus Maior (Marcos Vinícius) | Música Verbo Sede");
		playlist.add("Awesome God");
		playlist.add("Ensaio Sobre Luz - Marco Telles");
		playlist.add("Digno É o Cordeiro (Ao Vivo) | Gabi Sampaio, SOM DO CÉU, Thiago Henrique");
		playlist.add("Jesus Culture - Rooftops");
		playlist.add("Felipe Rodrigues - Gratidão - Ministração ao vivo");
		playlist.add("Felipe Rodrigues - Aclame Ao Senhor - Ministração ao vivo");
		playlist.add("Me Derramar - Vineyard Piratininga feat Guilherme Andrade");
		playlist.add("Maysa Ramos - Gratidão Me Ama Ao Vivo ‪pazsaopaulo");
		playlist.add("El Shaddai (Eliana Rodrigues) | Música Verbo Sede");
		playlist.add("Eu também (100 Bilhões X) | Música Verbo Sede");
		playlist.add("A Tua Presença (Eliana Rodrigues) | Música Verbo Sede");
		playlist.add("Santo Espírito | Música Verbo Sede");
		playlist.add("Livres - Juliano Son - Quando o mundo cai ao meu redor - Clipe Oficial HD");
		playlist.add("Existe Vida Aí - Jessé Aguiar");
		playlist.add("Deus Proverá - Gabriela Gomes");
		playlist.add("Tua Graça (feat. Leo Brandão) - DJ PV - Me Llevas Más Alto");
		playlist.add("Existe Vida Aí | Cover de Jessé Aguiar");
		playlist.add("DJ PV - Tua Graça feat. Léo Brandão (Lyric Video)");
		playlist.add("DigitalBomb - Até O Sol Raiar");
		playlist.add("Gabriela Gomes - Deus Proverá");
		playlist.add("Linkin Park - Leave Out All The Rest");
		playlist.add("Projota - Chuva De Novembro");	
		playlist.add("Projota - O vento");	
		playlist.add("Timbaland ft. OneRepublic - Apologize");
		
		
		System.out.println("\nPlaylist após as alterações: ");
		
		for (String musica : playlist) {
			System.out.println(musica);
		}

		if (playlist.contains("Evidências")) {
			System.out.println("\nA música Evidências está na playlist! :(");
		} else {
			System.out.println("\nA música Evidências não está na playlist. Ainda Bem !!! XD");
		}
	}
}
