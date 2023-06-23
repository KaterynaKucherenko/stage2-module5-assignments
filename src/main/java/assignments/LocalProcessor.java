package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.lang.StringBuilder;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private StringBuilder processorName;
    private Long period = 10000000000000L;
    protected StringBuilder processorVersion;
    private Integer valueOfCheap;
    Scanner informationScanner;
    static List<String> stringArrayList = new LinkedList<>();
    public LocalProcessor() {
    }
    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, List<String> stringArrayList) {
        this.processorName = new StringBuilder(processorName);
        this.period = period;
        this.processorVersion = new StringBuilder(processorVersion);
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        LocalProcessor.stringArrayList = stringArrayList;
    }


    @ListIteratorAnnotation
    public void listIterator(List<String> stringList)
    {
        if (stringList.size() != 0){
            stringArrayList = new LinkedList<>(stringList);
            for (String element : stringList)
            {
                if (element != null){
                    System.out.println(element.hashCode());
                }
            }
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList)
    {
        StringBuilder stringBuilder = new StringBuilder();
        if (processorName != null){
            stringBuilder.append(processorName);
        }
        if (stringList.size() != 0){
            for (String element : stringList)
            {
                if (element != null && !element.isEmpty()){
                    stringBuilder
                            .append(element)
                            .append(" ");
                }
            }
        }
        return String.valueOf(stringBuilder);
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file)
    {
        try (Scanner scanner = new Scanner(file))
        {
            informationScanner = scanner;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(processorVersion);
            while (informationScanner.hasNext())
            {
                if (informationScanner.nextLine() != null){
                    stringBuilder.append(informationScanner.nextLine());
                }
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}