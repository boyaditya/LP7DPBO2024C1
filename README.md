# LP7DPBO2024C1

## Desain Program
Program ini dirancang dengan menggunakan Java dan Swing untuk membuat GUI. Program ini terdiri dari lima kelas utama: App, FlappyBird, Pipe, Player, dan StartForm.  
1. App: Ini adalah titik masuk utama program. Dalam metode main, kita membuat instance dari StartForm dan membuatnya visible.
2. StartForm: Ini adalah form awal yang ditampilkan ketika program dijalankan. Form ini berisi tombol "Start Game". Ketika tombol ini ditekan, StartForm akan ditutup dan game FlappyBird akan dibuka.
3. FlappyBird: Ini adalah kelas utama untuk game. Kelas ini mengatur game loop, menggambar game ke layar, dan mengendalikan interaksi antara Player dan Pipe.
4. Pipe: Ini adalah kelas yang mewakili pipa dalam game. Setiap pipa memiliki posisi dan ukuran tertentu dan dapat bergerak ke kiri seiring berjalannya waktu.
5. Player: Ini adalah kelas yang mewakili pemain dalam game. Pemain dapat bergerak ke atas dan ke bawah dan memiliki posisi tertentu di layar.  

## Alur program:  
1. Program dimulai dan StartForm ditampilkan.
2. Pengguna menekan tombol "Start Game" di StartForm, yang menutup StartForm dan membuka game FlappyBird.
3. Game dimulai dan Player mulai bergerak. Pipe mulai muncul dari kanan dan bergerak ke kiri.
4. Skor diperoleh ketika pemain berhasil melewati pipa. Setiap kali pemain melewati pipa, skor akan bertambah satu. Ini diatur dalam metode actionPerformed di kelas FlappyBird.
5. Jika Player menabrak Pipe atau jatuh ke tanah, game berakhir dan metode gameOver dipanggil.
6. Jika game berakhir, game loop dan timer pipa dihentikan dan variabel isGameOver disetel ke true.
7. Pengguna dapat memulai ulang game dengan menekan tombol 'R' pada keyboard, yang akan memanggil metode restartGame dan mengatur ulang Player, Pipe, skor, dan status game.

## Dokumentasi
### Tampilan awal program
![image](https://github.com/boyaditya/LP7DPBO2024C1/assets/135103722/0f2d775c-461f-4f1c-83ec-3361467a5257)

### Tampilan in-game
![image](https://github.com/boyaditya/LP7DPBO2024C1/assets/135103722/b38c8dfa-ed12-4b22-8533-b8eb1f076673)



https://github.com/boyaditya/LP7DPBO2024C1/assets/135103722/2e559d57-a58a-43ad-9c0f-da5f092d4c9e



