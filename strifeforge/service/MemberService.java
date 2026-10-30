package strifeforge;

import java.util.ArrayList;
import java.util.List;

public class MemberService {
    private List<Member> members = new ArrayList<>();
    private int counter = 1;

    public MemberService() {
        // Data inisialisasi awal
        tambahMemberLangsung("Farrel Shidqi", "081299990001", "L", "Bekasi", "2004-03-12");
        tambahMemberLangsung("Siti Rahma", "081299990002", "P", "Jakarta", "2003-08-20");
    }

    private void tambahMemberLangsung(String nama, String telp, String jk, String alamat, String tglLahir) {
        String id = String.format("MBR%03d", counter++);
        members.add(new Member(id, nama, telp, jk, alamat, tglLahir));
    }

    public void tambahMember(String nama, String telp, String jk, String alamat, String tglLahir) {
        String id = String.format("MBR%03d", counter++);
        Member m = new Member(id, nama, telp, jk, alamat, tglLahir);
        members.add(m);
        System.out.println("[Sukses] Member baru berhasil didaftarkan dengan ID: " + id);
    }

    public List<Member> getSemuaMember() {
        return members;
    }

    public Member cariMemberById(String id) {
        for (Member m : members) {
            if (m.getId().equalsIgnoreCase(id)) return m;
        }
        return null;
    }

    public List<Member> cariMemberByNama(String keyword) {
        List<Member> hasil = new ArrayList<>();
        for (Member m : members) {
            if (m.getNama().toLowerCase().contains(keyword.toLowerCase())) {
                hasil.add(m);
            }
        }
        return hasil;
    }

    public boolean hapusMember(String id) {
        Member m = cariMemberById(id);
        if (m != null) {
            members.remove(m);
            return true;
        }
        return false;
    }
}