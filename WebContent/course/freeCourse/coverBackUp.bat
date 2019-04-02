rd /s /q e:\pbackup
rd /s /q f:\pbackup
rd /s /q d:\pbackup


mkdir f:\pbackup
mkdir e:\pbackup

mkdir d:\pbackup

mkdir f:\pbackup\CodeProject
mkdir e:\pbackup\CodeProject

mkdir d:\pbackup\CodeProject

mkdir f:\pbackup\Desktop
mkdir e:\pbackup\Desktop

mkdir d:\pbackup\Desktop

xcopy C:\Users\Amy_2\Desktop e:\pbackup\Desktop /s /h  /c /y
xcopy C:\Users\Amy_2\Desktop f:\pbackup\Desktop /s /h  /c /y

xcopy C:\Users\Amy_2\Desktop d:\pbackup\Desktop /s /h  /c /y

xcopy C:\Users\Amy_2\Documents\CodeProject e:\pbackup\CodeProject /s /h  /c /y
xcopy C:\Users\Amy_2\Documents\CodeProject f:\pbackup\CodeProject /s /h  /c /y
xcopy C:\Users\Amy_2\Documents\CodeProject d:\pbackup\CodeProject /s /h  /c /y


