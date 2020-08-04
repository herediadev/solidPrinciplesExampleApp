package documents;

public class WorkContract implements ExportableText, ExportablePdf, ExportableJson {
    private final String content;

    public WorkContract(String content) {
        this.content = content;
    }

    @Override
    public byte[] toPdf() {
        return content.getBytes();
    }

    @Override
    public String tJson() {
        return "{'content' : '" + content + "'}";
    }

    @Override
    public String toTxt() {
        return content;
    }
}
