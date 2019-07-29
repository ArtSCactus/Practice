/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.ProgrammingWithClasses;

/**
 * Task condition: 6. Составьте описание класса для представления времени.
 * Предусмотрте возможности установки времени и изменения его отдельных полей
 * (час, минута, секунда) с проверкой допустимости вводимых значений. В случае
 * недопустимых значений полей поле устанавливается в значение 0. Создать методы
 * изменения времени на заданное количество часов, минут и секунд.
 *
 * @author ArtSCactus
 */
public class Time {

    private int hours;
    private int minuts;
    private int seconds;

    public Time(int hours, int minuts, int seconds) {
        if (hours >= 24 | hours < 0) {
            this.hours = 0;
        } else {
            this.hours = hours;
        }
        if (minuts > 59 | minuts < 0) {
            this.minuts = 0;
        } else {
            this.minuts = minuts;
        }
        if (seconds > 59 | seconds < 0) {
            this.seconds = 0;
        } else {
            this.seconds = seconds;
        }
    }
/** Constructs default time value as 0:0:0.
 * 
 */
    public Time() {
        hours = 0;
        minuts = 0;
        seconds = 0;
    }
/** Settings new time value.
 * 
 * @param hours
 * @param minuts
 * @param seconds 
 */
    public void setTime(int hours, int minuts, int seconds) {
        if (hours >= 24 | hours < 0) {
            this.hours = 0;
        } else {
            this.hours = hours;
        }
        if (minuts > 59 | minuts < 0) {
            this.minuts = 0;
        } else {
            this.minuts = minuts;
        }
        if (seconds > 59 | seconds < 0) {
            this.seconds = 0;
        } else {
            this.seconds = seconds;
        }
    }
/** Setting new hours to current time. If given value more or equals than 24 or less than 0, hours setting on 0.
 * 
 * @param hours
 */ 
    public void setHours(int hours) {
        if (hours >= 24 | hours < 0) {
            this.hours = 0;
        } else {
            this.hours = hours;
        }
    }
/** Setting new minuts to current time. If given value more than 59 or less than 0, minuts setting on 0.
 * 
 * @param minuts
 */ 
    public void setMinuts(int minuts) {
        if (minuts > 59 | minuts < 0) {
            this.minuts = 0;
        } else {
            this.minuts = minuts;
        }
    }
/** Setting new seconds to current time. If given value more than 59 or less than 0, seconds setting on 0.
 * 
 * @param seconds 
 */ 
    public void setSeconds(int seconds) {
        if (seconds > 59 | seconds < 0) {
            this.seconds = 0;
        } else {
            this.seconds = seconds;
        }
    }
/** Returns current time as String row.
 * 
 * @return 
 */
    public String getTime() {
        return hours + ":" + minuts + ":" + seconds;
    }
/** Adding given hours to the current time.
 * 
 * @param hours 
 */
    public void addHours(int hours) {
        if (this.hours + hours >= 24 | this.hours + hours < 0) {
            hours = hours < 0 ? hours * -1 : hours;
            this.hours += hours;
            while (this.hours >= 24) {
                if (this.hours > 24) {
                    this.hours -= 24;
                } else if (this.hours == 24) {
                    this.hours = 0;
                }
            }
        } else {
            this.hours += hours;
        }
    }
/** Adding given minuts to the currentTime.
 * 
 * @param minuts 
 */
    public void addMinuts(int minuts) {
        if (this.minuts + minuts >= 59 | this.minuts + minuts < 0) {
            minuts = minuts < 0 ? minuts * -1 : minuts;
            this.minuts += minuts;
            while (this.minuts >= 60) {
                if (this.minuts > 60) {
                    addHours(1);
                    this.minuts -= 60;
                } else if (this.minuts == 60) {
                    addHours(1);
                    this.minuts = 0;
                }
            }
        } else {
            this.minuts += minuts;
        }
    }
/** Adding given seconds to the current time.
 * 
 * @param seconds 
 */
    public void addSeconds(int seconds) {
        if (this.seconds + seconds >= 59 | this.seconds + seconds < 0) {
            seconds = seconds < 0 ? seconds * -1 : seconds;
            this.seconds += seconds;
            while (this.seconds >= 60) {
                if (this.seconds > 60) {
                    addMinuts(1);
                    this.seconds -= 60;
                } else if (this.seconds == 60) {
                    addMinuts(1);
                    this.seconds = 0;
                }
            }
        } else {
            this.seconds += seconds;
        }
    }
/** Method to test how class Time works.
 * 
 */
    public static void testClass() {
        Time timer = new Time();
        System.out.println("Current time: " + timer.getTime());
        timer.addSeconds(7200);
        System.out.println("Current time: " + timer.getTime());
        timer.setTime(14, 53, 60);
        System.out.println("Current time: " + timer.getTime());
        timer.setHours(13);
        timer.setMinuts(30);
        timer.setSeconds(78);
        System.out.println("Current time: " + timer.getTime());

    }
}
