package openchat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test01 {

	public static String filterText(String sText)

	{

		Pattern p = Pattern.compile("천재", Pattern.CASE_INSENSITIVE);

		Matcher m = p.matcher(sText);
		StringBuffer buf = new StringBuffer();
		while (m.find())

		{

			m.appendReplacement(buf, maskWord(m.group()));

		}
		m.appendTail(buf);
		return buf.toString();

	}

	public static String maskWord(String str)

	{

		StringBuffer buf = new StringBuffer();
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++)

		{

			if (i < 1)

			{

				buf.append(ch[i]);

			} else {

				buf.append("**");

			}

		}
		return buf.toString();

	}

	public static void main(String[] args)

	{

		String text = "당신은 천재 입니다.";
		System.out.println(filterText(text));

	}

}
