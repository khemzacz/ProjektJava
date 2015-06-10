package maleOkienka;

import java.awt.Font;
import java.text.NumberFormat;
import java.util.Formatter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Stats extends JFrame implements Runnable
{
	private JPanel panel = new JPanel();
	
	private JLabel wygrane= new JLabel();
	private JLabel liczbaWygranych= new JLabel();
	private JLabel przegrane= new JLabel();
	private JLabel liczbaPrzegranych= new JLabel();
	private JLabel ratio= new JLabel();
	
	public Stats(String liczbaWygranych, String liczbaPrzegranych)
	{
		super("Statystyki");
		this.liczbaPrzegranych.setText(liczbaPrzegranych);
		this.liczbaWygranych.setText(liczbaWygranych);
		double tmp;
		tmp = ((double)Integer.parseInt(liczbaWygranych) / ((double)Integer.parseInt(liczbaPrzegranych) + (double)Integer.parseInt(liczbaWygranych)))*100;
		//ratio.setText(String.valueOf(tmp) + " %");
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMinimumFractionDigits(2);
		nf.setMaximumFractionDigits(2);
		ratio.setText("" + nf.format(tmp) + " %");
		//String pom = new String(String.valueOf(tmp));
		//ratio.setText(pom + " %");
		wygrane.setText("Zwycięstwa: ");
		Font font=new Font("Arial", 1,20);
		wygrane.setFont(font);
		przegrane.setText("Porażki: ");
		przegrane.setFont(font);
		ratio.setFont(font);
		this.liczbaWygranych.setFont(font);
		this.liczbaPrzegranych.setFont(font);
		
	}
	
	public void run() 
	{
		
		setSize(600,400);
		setLocationRelativeTo(null);
		
		panel.setLayout(null);
		wygrane.setBounds(50,50,150,40);
		liczbaWygranych.setBounds(205,50,45,40);
		przegrane.setBounds(300,50,100,40);
		ratio.setBounds(250,90,100,40);
		
		liczbaPrzegranych.setBounds(405,50,45,40);
		
		panel.add(wygrane);
		panel.add(przegrane);
		panel.add(liczbaWygranych);
		panel.add(liczbaPrzegranych);
		panel.add(ratio);
		panel.setVisible(true);
		add(panel);
		setVisible(true);
	}

}
